public class Ex1 {
    public static void main(String[] args) {
        System.out.println();

        for(int i = 0; i <= 100; i++){
            if(i % 2 == 0)
                System.out.println(i);
        }

        // Alternative implementation
        // for(int i = 0; i <= 100; i += 2)
        //     System.out.println(i);

        System.out.println();
    }
}