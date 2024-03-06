package TS;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ToyShop {
    private String[] ids;
    private String[] names;
    private int[] frequencies;
    private Queue<Toy> toyQueue;

    public ToyShop(String id1, String id2, String id3, String name1, String name2, String name3, int freq1, int freq2, int freq3) {
        this.ids = new String[]{id1, id2, id3};
        this.names = new String[]{name1, name2, name3};
        this.frequencies = new int[]{freq1, freq2, freq3};
        this.toyQueue = new PriorityQueue<>(Comparator.comparingInt(Toy::getFrequency));
        for (int i = 0; i < ids.length; i++) {
            toyQueue.offer(new Toy(ids[i], names[i], frequencies[i]));
        }
    }


    public Queue<Toy> getQueue() {
        return toyQueue;
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < 10; i++) {
                Toy toy = toyQueue.poll();
                writer.write(toy.getId() + " " + toy.getName() + "\n");
                toy.setFrequency(toy.getFrequency() + 1);
                toyQueue.offer(toy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
