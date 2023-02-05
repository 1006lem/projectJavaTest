

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PolicyList {
	private List<Policy> policyList = new ArrayList<>();
	
	/* -각종 policy들을 policyList에 insert,.. 메서드들 작성- */
	public void insert(Policy policy) {
		this.policyList.add(policy);
	}
	
	
	
	public List<Policy> getPolicyList() {
		return policyList;
	}



	public void setPolicyList(List<Policy> policyList) {
		this.policyList = policyList;
	}



	/* -policyList를 순회하며, 해당 policy의 조건과 맞는 pod를 찾는 method*/
	//만일 pod 하나가 추가된다면?
	//만일 policy 하나가 추가된다면?
	//지금의 코드는 하나가 갱신되면 모든 pod, policy를 다시 확인한다(비효율) 일단 이렇게 진행.
	public void selectPolicies(PodDao podDao) { // 이렇게 Dao class를 직접 써도 되는지에 대한 의문...**** (일다 controller에서 접근해 사용)
		List<Pod> namespaceAppliesPods = new ArrayList<Pod>();
		List<Pod> middleProcessDaoList = new ArrayList<Pod>();
		List<Pod> ToPods = new ArrayList<Pod>();
		List<Pod> FromPods = new ArrayList<Pod>();
		
		PodDao middlePodDao = new PodDao(); //PodDao 객체를 여러 개 둬도 괜찮은지에 대한 의문...******
		
		for (Policy policy : this.policyList) {
			System.out.println("[policy] : " + policy);
			
			//만일 namespace가 적혀있지 않다면 default namespace로 처리? (pod에 default라 적을지, 아니면 비어 있는 pod namespace를 이 메소드에서 default로 처리할지 고민중)
			namespaceAppliesPods = podDao.selectByNamespace(policy.getNamespace()); //namespace가 안나와있으면 다음 pod select 기준으로 넘어감 (selectByLabel)
			middlePodDao.setPods(namespaceAppliesPods);
			

			if (policy.getLabels() != null) {
				middleProcessDaoList = middlePodDao.selectByLabel(policy.getLabels());
			
				middlePodDao.setPods(middleProcessDaoList);
			}
			
			//--- 여기까지 하면 ingress, egress 조건 확인할 준비 완료
			
			//Egress 정책 (지금까지 구한 게 from Pods, 지금 구할 게 To Pods)
			if (policy.getEgress() != null) {
				System.out.println("[Egress] " + policy.getEgress());
				FromPods = middleProcessDaoList;  
				policy.setFromPods(FromPods);
			
				// PodDao class의 selectByEgressIngress에서 ingressEgress의 조건 존재 여부를 체크하기는 함 
				ToPods = podDao.selectByEgressIngress(policy.getEgress(), namespaceAppliesPods); //network policy의 spec.namespace에 따라 분류한 pod에 대해 점검
				if (ToPods == null) { //어떠한 값도 반환되지 않는다 -> egress 조건이 적용되는 ToPod 가 없다
					continue;
				}
				                                               
				//policy.insertPod 
				policy.setToPods(ToPods);
				for(Pod fromPod : FromPods) {
					for(Pod toPod : ToPods) {
						fromPod.addNextPod(toPod);	
					}
				}
				continue;
			}
			
			//-----------------------------------
			//Ingress 정책 (지금까지 구한 게 TO, Pods, 지금 구할 게 From pods)
			
			if(policy.getIngress() != null){// return;
				System.out.println("[ingress]" + policy.getIngress());
				
				ToPods = middleProcessDaoList; //from pods 구해짐 
				
				FromPods = podDao.selectByEgressIngress(policy.getIngress(), namespaceAppliesPods); //network policy의 spec.namespace에 따라 분류한 pod에 대해 점검
				if (FromPods == null) { //어떠한 값도 반환되지 않는다 -> egress 조건이 적용되는 ToPod 가 없다
					continue;
				}
				//null이 아니라면, 즉 어떠한 값이 반환 되기는 한다면 -> 이어줘야 한다
				
				//policy.insertPod //새로운 pod yaml이 들어오면..? 딱히 insertPod 안만들어도 될듯
				policy.setToPods(ToPods);
				
				for(Pod fromPod : FromPods) {
					for(Pod ToPod : ToPods) {
						fromPod.addNextPod(ToPod);	
					}
				}
			}
		}
	}
	
	/* -특정 policy 삭제
	public void delete(Policy policy) { //특정 policy 삭제
	
	}
	*/
}
