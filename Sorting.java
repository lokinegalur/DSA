
public class Sorting {
		static void bubbleSort(int arr[]){
	        int n=arr.length;
	        for(int i=0;i<n-1;i++){
	        	boolean swap=false;
	            for(int j=0;j<n-1-i;j++){
	                if(arr[j]>arr[j+1]){
	                    int t=arr[j];
	                    arr[j]=arr[j+1];
	                    arr[j+1]=t;
	                    swap=true;
	                }
	            }
	            if(!swap) break;          //efficient when already sorted
	        }
	    }
	    
		static void printArr(int[] arr){
	        System.out.println("-----------------");
	        for(int x:arr) System.out.print(x+" "); System.out.println();
	        System.out.println("-----------------");
	    }
		
		
	   static void bubbleSortRec(int[] arr,int i,int n) {           //recursive bubble sort
		   if(i==n-1)return;
		   for(int j=0;j<n-i-1;j++) {
				   if(arr[j]>arr[j+1]) {  
					   int t=arr[j];
					   arr[j]=arr[j+1];
					   arr[j+1]=t;
				   }
		   }
		   bubbleSortRec(arr,i+1,n);
	   }	
	   
	   static void selectionSort(int[] arr) {
		   int n=arr.length;
		   for(int i=0;i<n-1;i++) {
			   int mi=i;
			   for(int j=i+1;j<n;j++) {
				   if(arr[j]<arr[mi])
					   mi=j;
			   }
			   int t=arr[mi];
			   arr[mi]=arr[i];
			   arr[i]=t;
		   }
	   }
	   
	   
	   static void insertionSort(int[] arr) {
		   int n=arr.length;
		   for(int i=1;i<n;i++) {
			   int t=arr[i],j=i-1;
			   while(j>=0 && t<arr[j]) {
				   arr[j+1]=arr[j];
				   j--;
			   }
			   arr[j+1]=t;
		   }
	   }
	   
	   static void merge(int arr[],int l,int h) {
		   int mid=l+(h-l)/2;
		   int arr1[]=new int[h-l+1];
		   int i=l,j=mid+1,k=0;
		   while(i<=mid && j<=h) {
			   if(arr[i]<arr[j]) {
				   arr1[k]=arr[i];
				   i++;
			   }
			   else {
				   arr1[k]=arr[j];
				   j++; 
			   }
			   k++;
		   }
		   while(i<=mid) {
			   arr1[k]=arr[i];
			   i++;k++;
		   }
		   while(j<=h) {
			   arr1[k]=arr[j];
			   j++;k++;
			   }
		   i=l;k=0;
		   while(i<=h) {
			   arr[i]=arr1[k];
			   k++;i++;
		   }
	   }
	   
	   static void mergeSort(int[] arr,int l,int h) {
		   if(l==h) return;
		   int mid=l+(h-l)/2;
		   mergeSort(arr,l,mid);
		   mergeSort(arr,mid+1,h);
		   merge(arr,l,h);
	   }
	   
	   static void mergeInplace(int[] arr,int l,int h) {           //merge sorted arrays inplace without extra space
		   int mid=l+(h-l)/2;
		   int i=l,j=mid+1,k=l;
		   int mx=Math.max(arr[mid],arr[h])+1;
		   while(i<=mid && j<=h && k<=h) {
			   int e1=arr[i]%mx;
			   int e2=arr[j]%mx;
			   if(e1<=e2) {
				   arr[k]+=(e1*mx);
				   k++;i++;
			   }
			   else {
				   arr[k]+=(e2*mx);
				   k++;j++;
			   }
		   }
		   while(i<=mid) {
			   int e1=arr[i]%mx;
			   arr[k]+=(e1*mx);
			   k++;i++;
		   }
		   while(j<=h) {
			   int e2=arr[k]%mx;
			   arr[k]+=(e2*mx);
			   k++;j++;
		   }
		   System.out.println("print array");
		   for(i=l;i<=h;i++) {
			   System.out.print(arr[i]+" ");
			   arr[i]/=mx;
		   }
	   }
	   
	   static void mergeSortInplace(int[] arr,int l,int h) {           //inplace merge sort
		   if(l==h) return;
		   int mid=l+(h-l)/2;
		   mergeSortInplace(arr,l,mid);
		   mergeSortInplace(arr,mid+1,h);
		   mergeInplace(arr,l,h);
	   }
	   
	    public static void main(String args[]) {
	        int[] arr={4,3,2,1};
	        bubbleSort(arr);
	        printArr(arr);
	        int arr1[]= {5,4,3,2,1};
	        bubbleSortRec(arr1,0,arr1.length);  
	        printArr(arr1);
	        int arr3[]= {9,8,7,5,4,3,2,1};
	        selectionSort(arr3);
	        printArr(arr3);
	        int arr4[]= {4,5,67,87,1,4,2,9,3,2,0};
	        insertionSort(arr4);
	        printArr(arr4);
	        int arr5[]= {1,2,3,4,5,5,1,2,3,4,5,6,7};
	        mergeSort(arr5,0,arr5.length-1);
	        printArr(arr5);
	        int arr6[]= {7,6,6,5,4,3,2,1,0};
	        mergeSortInplace(arr6,0,arr6.length-1);
	        printArr(arr6);
	        
	    }
}
