
/*
public class NoMain {
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
}

	/*
	 * //새로운 yaml 파일을 입력하고, 이것이 정상적으로 동작하는지 확인
			//이후에 실제로 rest API를 통해 데이터가 JSON으로 왔을 때, 아를 class로 처리하는 부분 처리
			// 또한 알고리즘을 통해 생성한 그래프 관련 정보를 JSON으로 만들어 프론트엔드로 보내는 부분 처리
			// 이후에는 알고리즘적으로 구현을 더한다 (policy를 삭제, pod 생성...)
			
			//이후에는 환경 정보가 인프라로부터 넘어올 때의 코드 작성 .... -> 아니다. 어차리 파싱만 잘 하면 되는거 아닌가?
			
			//지금까지는 link를 기준으로 알고리즘을 작성했지만 그렇게 하지 않아도 될 것 같다는 생각이....
			//시간 되면 고쳐보자 
	 */
	/*
		public static void main(String[] args) {
		
			//Controller controller = new Controller();
			
			Pod pod1 = new Pod(); //파싱된 pod 객체가 있다고 가정
			Pod pod2 = new Pod(); //파싱된 pod 객체가 있다고 가정
			Pod pod3 = new Pod(); //파싱된 pod 객체가 있다고 가정
			
			pod1.setName("pod1"); //관리 용도 (백엔드에서 pod를 지칭/구별하는 이름)
			pod2.setName("pod2");
			pod3.setName("pod3");
			
			//Map<String, String> labels
			Map<String, String> label1 = new HashMap<String, String>();
			Map<String, String> label2 = new HashMap<String, String>();
			Map<String, String> label3 = new HashMap<String, String>();
			label1.put("test", "hi");
			label2.put("test", "hello");
			label3.put("test", "hello");
			
			pod1.setLabels(label1);
			pod2.setLabels(label2);
			pod3.setLabels(label3);
			
			pod1.setNamespace("namespace1");
			pod2.setNamespace("namespace1");
			pod3.setNamespace("namespace1");
			
			//IP를 위한 객체를 생성해서 다뤄야 할 것 같음  -우선은 처리 x
			pod1.setIp("10.0.0.1");
			pod2.setIp("10.0.1.0");
			pod3.setIp("10.0.20.3");
			
			
			pod1.setPort("8080");
			pod2.setPort("8000");
			pod3.setPort("53");
			
			
			// ----------------------------------- 
			
			Policy policy1 = new Policy(); //파싱된 policy 객체가 있다고 가정
			//Policy policy2 = new Policy(); //파싱된 policy 객체가 있다고 가정
			//Policy policy3 = new Policy(); //파싱된 policy 객체가 있다고 가정
		
			policy1.setName("policy1");
			//policy2.setName("policy2");
			//policy3.setName("policy3");
			

			Map<String, String> label4 = new HashMap<String, String>();
			label4.put("test", "hi");
			
			policy1.setLabels(label4);
			//policy2.setLabels(label5);
			//policy3.setLabels(label6);
			
			policy1.setNamespace("namespace1");
			//policy2.setNamespace("namespace1");
			//policy3.setNamespace("namespace1");
			Map<String, String> label5 = new HashMap<String, String>();
			label5.put("test", "hello");
			
			
			//label7.put("namespaceLabel", "namespaceLabel1");
			
			//label9.put("namespaceLabel", "namespaceLabel3");
			
			//namespace Label에 대해 객체 생성 or 
			
			IngressEgressPolicy IngressEgressPolicy1 = new IngressEgressPolicy();
			//IngressEgressPolicy1.setIpBlock(null);
			//IngressEgressPolicy1.setNamespaceSelectorLabel(label7); //객체(class)로 생성해야 할듯 
			IngressEgressPolicy1.setPodSelectorLabel(label8);
			//IngressEgressPolicy1.setPort(null);
			//ingressEgressPolicy1.setIpBlock();
			
			
			
			IngressEgressPolicy IngressEgressPolicy1 = new IngressEgressPolicy();
			//IngressEgressPolicy1.setIpBlock(null);
			//IngressEgressPolicy1.setNamespaceSelectorLabel(label7); //객체(class)로 생성해야 할듯 
			IngressEgressPolicy1.setPodSelectorLabel(label5);
			//IngressEgressPolicy1.setPort(null);
			//ingressEgressPolicy1.setIpBlock();
			
			policy1.setEgress(IngressEgressPolicy1);
			
			//IP를 위한 객체를 생성해서 다뤄야 할 것 같음  -우선은 처리 x
			pod1.setIp("10.0.0.1");
			pod2.setIp("10.0.1.0");
			pod3.setIp("10.0.20.3");
			
			
			List<Pod> pods = new ArrayList<Pod>();
			pods.add(pod1);
			pods.add(pod2);
			pods.add(pod3);
			
			PodDao podDao = new PodDao();
			podDao.setPods(pods);
					
			
			PolicyList policyList = new PolicyList();
			policyList.insert(policy1);
			
			
			
			for (Pod pod : podDao.getPods()) {
				System.out.println("이것은" + pod.getName() + " pod에 대한 정보입니다.");
				System.out.println(pod);
			}
			System.out.println("====================================\n");
			
			policyList.selectPolicies(podDao);
			
			
			for (Pod pod : podDao.getPods()) {
				System.out.println("이것은" + pod.getName() + " pod에 대한 정보입니다.");
				for (Pod nextPod : pod.getNextPods()) {
					System.out.println("next node: " + nextPod.getName() + "\n");
				}
				System.out.println("====================================\n");
				
			}
		}
		
		
	}
	*/
