package stackandqueue.catdogqueue;

import java.util.LinkedList;
import java.util.Queue;

//实现一种猫狗队列，其add方法可以将cat或者dog对象放入队列中，pollAll方法将队列中所有对象按顺序弹出，
//pollCat方法将所有cat对象按顺序弹出，pollDog方法将所有dog对象按顺序弹出......
public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue(){
        dogQ = new LinkedList<PetEnterQueue>();
        catQ = new LinkedList<PetEnterQueue>();
        count = 0;
    }

    public void add(Pet pet){
        if (pet.getType().equals("dog"))
            dogQ.add(new PetEnterQueue(pet, count++));
        else if (pet.getType().equals("cat"))
            catQ.add(new PetEnterQueue(pet, count++));
        else throw new RuntimeException("not a cat or dog.");
    }

    public Pet pollAll(){
        if (!catQ.isEmpty() && !dogQ.isEmpty()){
            if (dogQ.peek().getCount() < catQ.peek().getCount())
                return dogQ.poll().getPet();
            else return catQ.poll().getPet();
        }else if (!catQ.isEmpty())
            return catQ.peek().getPet();
        else if (!dogQ.isEmpty())
            return dogQ.peek().getPet();
        else throw new RuntimeException("queue is empty.");
    }

    public Dog pollDog(){
        if (!this.isDogQueueEmpty())
            return (Dog) dogQ.poll().getPet();
        else throw new RuntimeException("dog queue is empty.");
    }

    public Cat pollCat(){
        if (!this.isCatQueueEmpty())
            return (Cat) catQ.poll().getPet();
        else throw new RuntimeException("cat queue is empty.");
    }

    public boolean isDogQueueEmpty(){
        return dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty(){
        return catQ.isEmpty();
    }

    public boolean isEmpty(){
        return dogQ.isEmpty() && catQ.isEmpty();
    }
}
