
class Node{
  int val;
  IntStream st;
}
Heap<Node> hp;
IntStream merge(IntStream[] stream){
  hp = new Heap();
  for(Intstream st:stream){
    if !st.hasNext()
      continue;
    Node tmp = new Node(st.next(), st);
    hp.add(st);
  }
}

int next(){
  Node tmp;
  tmp = hp.get_max();
  hp.remove_max();
  int result;
  result = tmp.val;
  if (tmp.st.hasNext()){
    tmp.val = st.next();
    hp.insert(tmp);
  }
  return result;
}

int hasNext(){
  return !hp.isEmpty();
}
