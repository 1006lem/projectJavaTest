
## Test Case

### [pod and policy]

- Pod [name=pod1, labels={test=hi}, namespace=namespace1, ip=null, port=8080, policies=[null, null], nextPods=[]]
- Pod [name=pod2, labels={test2=del, test=hello}, namespace=namespace1, ip=null, port=8000, policies=[null, null], nextPods=[]]
- Pod [name=pod3, labels={test=hello}, namespace=namespace1, ip=null, port=53, policies=[null, null], nextPods=[]]
- Pod [name=pod4, labels={test2=del}, namespace=namespace1, ip=null, port=20, policies=[null, null], nextPods=[]]
- Policy [name=policy1, namespace=namespace1, labels={test=hi}, egress=IngressEgressPolicy [ipBlock=null, namespaceSelectorLabel=null, podSelectorLabel={test=hello}, port=null], ingress=null]
- Policy [name=policy2, namespace=namespace1, labels={test=hello}, egress=null, ingress=IngressEgressPolicy [ipBlock=null, namespaceSelectorLabel=null, podSelectorLabel={test2=del}, port=null]]
--- 

### [결과] 

- 이것은pod1 pod에 대한 정보입니다.
  - next node: pod2
  - next node: pod3

---

- 이것은pod2 pod에 대한 정보입니다.
  - next node: pod2
  - next node: pod3

--- 

- 이것은pod3 pod에 대한 정보입니다.

---

- 이것은pod4 pod에 대한 정보입니다.
  - next node: pod2
  - next node: pod3








