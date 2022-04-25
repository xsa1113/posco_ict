package 버블정렬;

public class 버블정렬 {
	public static void main(String[] args) {
		int[] item = new int[] {34,27,19,51,8,24,11};
		Sort S = new Sort();
		System.out.print("\n sort p : ");
		for(int i=0; i<item.length; i++)
			System.out.printf(" %d", item[i]);
		System.out.println();
		S.bubbleSort(item);
	}
}

class Sort{
	public void bubbleSort(int a[]) {
		int i,j,temp,size;
		size = a.length;
		for(i=size-1; i>0; i--) {
			System.out.printf("\n bubble sort %d step :", size-i);
			for(j=0; j<i; j++) {
				if(a[j] > a[j+1]) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
				System.out.printf("\n\t");
				for(int k=0; k<size; k++)
					System.out.printf("%3d",a[k]);
			}
		}
	}
}
