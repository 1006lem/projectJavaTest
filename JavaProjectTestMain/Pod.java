
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pod {

	
	/*-필드-*/
	private String name;
	private Map<String, String> labels = new HashMap<String, String>(); //라벨이 여러개일테니 key,value로 나타내기 위해 Map사용         //pod select 
	private String namespace;
	private String ip;
	private String port;
	private List<Pod> nextPods = new ArrayList<Pod>();
	/*
	private List<Policy>[] policies = new ArrayList[2]; //2차원 배열(flag, policy) //network policy 삭제를 고려 
	// -> policies[0] = FLAG.FROM(0), policies[1] = FLAG.TO(1)
	// -> policies[0][0] = this(pod)가 FLAG.FROM의 조건에 해당하는 네트워크 정책 1
	*/
	
	//private String service; - 일단 고려 x
	//private String endPoint; - 일단 고려 x
	//... 등등 필요한 필드는 추가예정
	/*-필드-*/
	
	/*-생성자-*/
	public Pod(String name, Map<String, String> labels, String nameSpace, String ip, String port, String service,
			String endPoint) {
		super();
		this.name = name;
		this.labels = labels;
		this.namespace = nameSpace;
		this.ip = ip;
		this.port = port;
		//this.service = service;
		//this.endPoint = endPoint;
	}
	
	public Pod() {};
	/*-생성자-*/
	
	
	
	/* -getter/setter- */
	public List<Pod> getNextPods() {
		return this.nextPods;
	}
	public void addNextPod(Pod pod) {
		this.nextPods.add(pod); 
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, String> getLabels() {
		return labels;
	}
	public void setLabels(Map<String, String> labels) {
		this.labels = labels;
	}
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String nameSpace) {
		this.namespace = nameSpace;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	/* -getter/setter- */
	

	
	/* -(field)policies 리스트에 값을 채우는 method 작성*/
	//Policy.java의 insertFromPods method, insertToPods에서 사용합니다
	//한 policy의 대상이 되는 pod를 찾았을 때 해당 pod에도 어떠한 policy가 쓰이는지를 적어두는 것입니다
	/*
	public void inserPolicy(Policy policy, FLAG flag) {
		this.policies[flag.ordinal()].add(policy);  //flag가 FROM이라면 policies[0]에, flag가 TO라면 policies[1]에 policy가 저장됩니다
	}
	*/
	
	
	/* -label put/remove- */
	public void putLabels(String key, String value) {
		this.labels.put(key, value);
	}
	
	public void removeLabels(String key) {
		this.labels.remove(key);
	}
	/* --- */
	
	
	/*
	@Override
	public String toString() {
		return "Pod [name=" + name + ", labels=" + labels + ", namespace=" + namespace + ", ip=" + ip + ", port=" + port
				+ ", policies=" + Arrays.toString(policies) + ", nextPods=" + nextPods + "]";
	}
	*/
	@Override
	public String toString() {
		return "Pod [name=" + name + ", labels=" + labels + ", namespace=" + namespace + ", ip=" + ip + ", port=" + port
				+ ", policies=" + ", nextPods=" + nextPods + "]";
	}
}

