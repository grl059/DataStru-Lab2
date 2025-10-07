package Lab2;

import dataStructures.Chain;

public class MyChain extends Chain {
    public void Add(Object Element) {
        add(size(), Element);
    }

    public Object[] toArray() {
        Object[] list = new Object[size()];
        for (int i = 0; i < size(); i++) {
            list[i] = get(i);
        }
        return list;
    }

    public void addRange(Object[] elements) {
        for (int i = 0; i < elements.length; i++) {
            Add(elements[i]);

        }

    }

    public MyChain intersection(MyChain chain) {
        MyChain result = new MyChain();
        MyChain tmp = new MyChain();
        tmp.addRange(this.toArray());
        for (int i = 0; i < chain.size(); i++) {
            Object element = chain.get(i);
            if (tmp.indexOf(element) > -1) {
                result.Add(element);
                tmp.remove(tmp.indexOf(element));
            }

        }
        return result;
    }

    public MyChain union(MyChain chain) {
        MyChain result = new MyChain();
        MyChain inter = this.intersection(chain);
        result.addRange(this.toArray());
        result.addRange(chain.toArray());
        for (int i = 0; i < inter.size(); i++) {
            result.remove(result.indexOf(inter.get(i)));
        }
        return result;
    }

}

