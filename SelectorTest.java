package test;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class SelectorTest {

    public static void main(String[] args) throws Exception {
        int port = 9999; // the port to listen

        ServerSocketChannel channel = ServerSocketChannel.open(); // here we create a ServerSocketChannel
        channel.configureBlocking(false); // set channel to non-blocking mode, becareful, FileChannel can not be set to
                                          // non-blocking mode!

        channel.socket().bind(new InetSocketAddress(port)); // bind address on port
        Selector selector = Selector.open(); // create a selector
        SelectionKey selKey = channel.register(selector, SelectionKey.OP_ACCEPT); // regist selector upon channel for
                                                                                  // interest `accept` event

        int interestSet = selKey.interestOps(); // get interest set

        boolean is_accept = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT;

        System.out.println("isAccept:" + is_accept); // check if is_accept opt is registered
        
        twoSum(new int[] { 2, 7, 9, 15 }, 9);
    }

    //[2,7,11,15] 9
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2)
            return res;

        int max = nums[0];
        int min = nums[0];
        // 15 2
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i])
                max = nums[i];
            if (min > nums[i])
                min = nums[i];
        }
        // 14
        int[] index = new int[max - min + 1];
        int other = 0;
        for (int i = 0; i < nums.length; i++) {
            other = target - nums[i];
            if (other < min || other > max) {
                continue;
            }
            if (index[other - min] > 0) {
                res[0] = index[other - min] - 1;
                res[1] = i;
                return res;
            }
            index[nums[i] - min] = i + 1;
        }
        return res;
    }
}
