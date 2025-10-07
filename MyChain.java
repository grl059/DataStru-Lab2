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
        /* 2 chain нэмж үүсгэж байгаа.
        Эхнийх нь болохоор буцааж байгаа хариу.
        2 дахь нь өөрийнх нь copy.
        3 дахь мөр нь өөрийгөө Array болгоод тэрийгээ tmp рүү оруулсан.
        4 дэх мөр chain ээрээ давталт явуулна.
        5 дахь мөр нь chain ийнхаа I дахь элемэнтийг аваад хадгалж байгаа.
        6 дахь мөр нь tmp дотор байгаа эсэхийг нь шалгаж байгаа.
        Байхгүй бол -1 байгаа бол Index ээ буцаана.
        Хэрэв байгаа бол тэрийгээ result дотроо нэмнэ. Тэгээд tmp гээс хасна.
         */
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
        /* Энэн дээр бол 2 chain нэмж үүсгэж байгаа.
            Нэг нь буцаах хариу, нөгөөх нь огтлолцол.
            result дотроо өөрийгөө copydood нэмж байгаа.
            Ард нь дахиад өгөгдсөн chain ийг copydood оруулна.
            Тэгээд result ээсээ огтлолцол дотор байгаа бүх элемэнтээ хасна.
        */
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