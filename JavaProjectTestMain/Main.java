import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 		// 추가로 해야 할 사항 
 * 		//새로운 yaml 파일을 입력하고, 이것이 정상적으로 동작하는지 확인
		//이후에 실제로 rest API를 통해 데이터가 JSON으로 왔을 때, 아를 class로 처리하는 부분 처리
		// 또한 알고리즘을 통해 생성한 그래프 관련 정보를 JSON으로 만들어 프론트엔드로 보내는 부분 처리
		// 이후에는 알고리즘적으로 구현을 더한다 (policy를 삭제, pod 생성...)
		
		//이후에는 환경 정보가 인프라로부터 넘어올 때의 코드 
 */

public class Main {
	
	public static void main(String[] args) {
	
		//-------------------------------------------------------- pod 생성
		Pod pod1 = new Pod(); //파싱된 pod 객체가 있다고 가정
		Pod pod2 = new Pod(); //파싱된 pod 객체가 있다고 가정
		Pod pod3 = new Pod(); //파싱된 pod 객체가 있다고 가정
		Pod pod4 = new Pod(); //파싱된 pod 객체가 있다고 가정
		
		pod1.setName("pod1"); //관리 용도 (백엔드에서 pod를 지칭/구별하는 이름)
		pod2.setName("pod2");
		pod3.setName("pod3");
		pod4.setName("pod4");
		
		
		Map<String, String> label1 = new HashMap<String, String>();
		Map<String, String> label2 = new HashMap<String, String>();
		Map<String, String> label3 = new HashMap<String, String>();
		Map<String, String> label4 = new HashMap<String, String>();
		//label1.put("test", "hi");
		//label2.put("test", "hello");
		label3.put("test", "hello");
		label4.put("test2", "del");
		
		pod1.putLabels("test", "hi");
		pod2.putLabels("test", "hello");
		pod2.putLabels("test2", "del");
		pod3.setLabels(label3);
		pod4.setLabels(label4);
		
		pod1.setNamespace("namespace1");
		pod2.setNamespace("namespace1");
		pod3.setNamespace("namespace1");
		pod4.setNamespace("namespace1");
		
		/*//IP 
		pod1.setIp("10.0.0.1");
		pod2.setIp("10.0.1.0");
		pod3.setIp("10.0.20.3");
		*/
		
		pod1.setPort("8080");
		pod2.setPort("8000");
		pod3.setPort("53");
		pod4.setPort("20"); // ************************** port가 null이면 출력 안됨 .. 처리해주자
		
		
		// -------------------------------------------------------- policy 생성 
		
		Policy policy1 = new Policy(); //파싱된 policy 객체가 있다고 가정
		Policy policy2 = new Policy(); //파싱된 policy 객체가 있다고 가정
	
		policy1.setName("policy1");
		policy2.setName("policy2");
		

		Map<String, String> label5 = new HashMap<String, String>();
		label5.put("test", "hello");
		
		Map<String, String> label6 = new HashMap<String, String>();
		label6.put("test2", "del");
		
		Map<String, String> label7 = new HashMap<String, String>();
		label7.put("test", "hi");
		Map<String, String> label8 = new HashMap<String, String>();
		label8.put("test", "hello");
		
		policy1.setLabels(label7);
		policy2.setLabels(label8);
		
		policy1.setNamespace("namespace1");
		policy2.setNamespace("namespace1");
		
		IngressEgressPolicy IngressEgressPolicy1 = new IngressEgressPolicy();
		//IngressEgressPolicy1.setIpBlock(null);
		//IngressEgressPolicy1.setNamespaceSelectorLabel(label7); //객체(class)로 생성해야 할듯 
		IngressEgressPolicy1.setPodSelectorLabel(label5);
		//IngressEgressPolicy1.setPort(null);
		//ingressEgressPolicy1.setIpBlock();
		
		policy1.setEgress(IngressEgressPolicy1);
		
		
		IngressEgressPolicy IngressEgressPolicy2 = new IngressEgressPolicy();
		//IngressEgressPolicy1.setIpBlock(null);
		//IngressEgressPolicy1.setNamespaceSelectorLabel(label7); //객체(class)로 생성해야 할듯 
		IngressEgressPolicy2.setPodSelectorLabel(label6);
		//IngressEgressPolicy1.setPort(null);
		//ingressEgressPolicy1.setIpBlock();
		policy2.setIngress(IngressEgressPolicy2);
		
		
		
		// -------------------------------------------------------- PodDao, PolicyList 생성 
		
		List<Pod> pods = new ArrayList<Pod>();
		pods.add(pod1);
		pods.add(pod2);
		pods.add(pod3);
		pods.add(pod4);
		
		PodDao podDao = new PodDao();
		podDao.setPods(pods);
				
		
		PolicyList policyList = new PolicyList();
		policyList.insert(policy1);
		policyList.insert(policy2);
		
		
		// -------------------------------------------------------- 
		for (Pod pod : podDao.getPods()) {
			System.out.println("이것은" + pod.getName() + " pod에 대한 정보입니다.");
			System.out.println(pod);
		}
		System.out.println("\n");
		for (Policy policy : policyList.getPolicyList()) {
			System.out.println("이것은" + policy.getName() + " policy에 대한 정보입니다.");
			System.out.println(policy);
		}
		System.out.println("====================================\n");
		
		policyList.selectPolicies(podDao); //policy 적용 
		
		
		for (Pod pod : podDao.getPods()) {
			System.out.println("이것은" + pod.getName() + " pod에 대한 정보입니다.");
			for (Pod nextPod : pod.getNextPods()) {
				System.out.println("next node: " + nextPod.getName() + "\n");
			}
			System.out.println("====================================\n");
			
		}
	}
	
	
}
