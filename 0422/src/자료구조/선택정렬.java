package 자료구조;

public class 선택정렬 {
	public static void main(String[] args) {
		int a[] = {69,10,30,2,16,8,31,22};
		int size = a.length;
		Sort s = new Sort();
		System.out.printf("\n sort ob : ");
		for(int i=0; i<a.length; i++)
			System.out.printf(" %d ", a[i]);
		System.out.println();
		s.insertionSort(a,size);
	}

}

class Sort{
	public void insertionSort(int a[], int size) {
		int i, j, t, temp;
		for(i=1; i<size; i++) {
			temp = a[i];
			j=i;
			while((j>0) && (a[j-1] > temp)) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = temp;
			System.out.printf("\n insertsort %d step : ", i);
			for(t=0; t<size; t++)
				System.out.printf("%3d", a[t]);
		}
		System.out.println();
	}
}