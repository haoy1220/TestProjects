package 集合;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ArrayList扩容 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        System.out.println(getArrayListCapacity(arrayList));
        int capavity = getArrayListCapacity(arrayList);
        for (int i = 0; i < 5; i++) {
            while (capavity == getArrayListCapacity(arrayList)){
                arrayList.add(1);
            }
            capavity = getArrayListCapacity(arrayList);
            System.out.println(getArrayListCapacity(arrayList) + "===========" + capavity);
        }

    }

    private static int getArrayListCapacity(ArrayList<Integer> arrayList) throws NoSuchFieldException, IllegalAccessException {
        Class<ArrayList> arrayListClass = ArrayList.class;

        Field field = arrayListClass.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] objects = (Object[])field.get(arrayList);
        return objects.length;
    }
}
