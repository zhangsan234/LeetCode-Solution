/**
 * @author Zhangsan
 * @date 2020/10/31 10:56
 */
public class Main {
    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(2);
        randomizedCollection.insert(3);
        randomizedCollection.insert(2);

        System.out.println(randomizedCollection.list.size());
        System.out.println();
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());

        System.out.println("-------------------------------------------------------------------");
        randomizedCollection.remove(2);

        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());


        System.out.println("-------------------------------------------------------------------");
        for(int i : randomizedCollection.list){
            System.out.print(i);
        }
    }
}
