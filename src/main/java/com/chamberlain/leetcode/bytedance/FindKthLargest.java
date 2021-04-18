package com.chamberlain.leetcode.bytedance;

/**
 * Created by chamberlain on 2021/4/18.
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        int result = 0;
        int length = nums.length;
        build_max_heap(nums, length);
        while(k > 0){
            result = Heap_extract_max(nums, length--);
            k--;
            if (k == 0){
                break;
            }
        }

        return result;
    }

    void build_max_heap(int heapArray[],int length){//通过普通数组构建最大堆
        for(int i=length/2;i>=1;i--){
            Max_Heapify(heapArray,i,length);
        }
    }

    int Heap_extract_max(int heapArray[],int length){//在最大堆里提取key值最大的元素,删除后保持最大堆状态
        if(length<1){
            return 0;
        }
        int max=heapArray[0];
        heapArray[0]=heapArray[length-1];
        length=length-1;
        Max_Heapify(heapArray,1,length);//为了让新堆保持最大堆
        return max;

    }

    void Max_Heapify(int heapArray[],int i,int length){//调整数组的顺序，使其满足最大堆性质
        int left=2*i;//左子树跟节点下标
        int right=2*i+1;//右子树跟节点下标
        int largest;
        if(left<=length&&heapArray[left-1]>heapArray[i-1]){//左子树根节点大于跟节点
            largest=left;
        }else{
            largest=i;
        }
        if(right<=length&&heapArray[right-1]>heapArray[largest-1]){//左子树根节点大于跟节点
            largest=right;
        }
        if(largest!=i){
            int temp=heapArray[largest-1];
            heapArray[largest-1]=heapArray[i-1];
            heapArray[i-1]=temp;
            Max_Heapify(heapArray,largest,length);
        }
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest.findKthLargest(nums, k));
    }
}
