public class Runner{

    public static void main(String[] args){
        LinkedList list = new LinkedList();
        Peeps Uyi = new Peeps();
        Uyi.setName("Omoruyi Omofonmwan");
        Uyi.setJob("Java Developer");
        list.insert(Uyi);
        list.show();
        System.out.println();

        Peeps Osaretin = new Peeps();
        Osaretin.setName("Osaretin Omofonmwan");
        Osaretin.setJob("Officer");
        list.insert(Osaretin);
        list.show();
        System.out.println();

        Peeps Ade = new Peeps();
        Ade.setName("Adebayo Uwensuyi");
        Ade.setJob("Software Engineer");
        list.insertAtStart(Ade);
        list.show();
        System.out.println();

        Peeps Boye = new Peeps();
        Boye.setName("Ajiboye Uwensuyi");
        Boye.setJob("Professional Gamer");
        list.insertAt(1, Boye);
        list.show();
        System.out.println();

    }
}