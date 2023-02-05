

import java.util.ArrayList;
import java.util.Map;

public class IngressEgressPolicy {
	private Cidr ipBlock; // pod select 기준 1
	private Map<String, String> namespaceSelectorLabel; // pod select 기준 2 (label)
	private Map<String, String> podSelectorLabel; //pod select 기준 3 (label)
	private String port; //ingress/egress를 통해 연결될 때의 포트(추가정보) 
	
	/* -getter/setter- */
	public Cidr getIpBlock() {
		return ipBlock;
	}
	public void setIpBlock(Cidr ipBlock) {
		this.ipBlock = ipBlock;
	}
	
	public Map<String, String> getNamespaceSelectorLabel() {
		return namespaceSelectorLabel;
	}
	public void setNamespaceSelectorLabel(Map<String, String> namespaceSelectorLabel) {
		this.namespaceSelectorLabel = namespaceSelectorLabel;
	}
	public Map<String, String> getPodSelectorLabel() {
		return podSelectorLabel;
	}
	public void setPodSelectorLabel(Map<String, String> podSelectorLabel) {
		this.podSelectorLabel = podSelectorLabel;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	/* -getter/setter- */
	
	
	@Override
	public String toString() {
		return "IngressEgressPolicy [ipBlock=" + ipBlock + ", namespaceSelectorLabel=" + namespaceSelectorLabel
				+ ", podSelectorLabel=" + podSelectorLabel + ", port=" + port + "]";
	}
	
}
