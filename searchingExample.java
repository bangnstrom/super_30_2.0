package dayfour;

public class searchingExample {
    
    static int sequentialSearch(int a[],int key){
//  only search that can work on unordered data
        for(int i =0;i<a.length;i++){
            if(key == a[i]){
                return i;     //found and returing index
            }
            
        }
        return -1;
    }

    static int binarySearch(int a[],int start,int end,int key){

        // only start this when data is in range
        if(start<=end)
        {
            int mid = (start+end)/2;
            if(key == a[mid]){
                return mid;
            }
            else{
                if(key<a[mid]){
                    return binarySearch(a, start, mid-1, key);
                }
                else{
                    return binarySearch(a, mid+1, end, key);

                }
            }
        }
        else{
            return -1;
        }
    }



    public static void main(String[] args) {
        int a[] ={34,65,35,34,75,87,36,20};
        int end = a.length-1;
        int start=0;
        System.out.println(binarySearch(a, start, end, 75));
    }

}
