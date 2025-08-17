import java.util.Random;
 
public class MyArrayList<E> 
{
  private int size; // Number of elements in the list
  private E[] data;
  /** Create an empty list */
  public MyArrayList() {
       data = (E[])new Object[100];// cannot create array of generics
       size = 0; // Number of elements in the list
  }
  
  public void add(int index, E e) {   
    // Ensure the index is in the right range
    if (index < 0 || index > size)
      throw new IndexOutOfBoundsException
        ("Index: " + index + ", Size: " + size); 
    // Move the elements to the right after the specified index
    for (int i = size - 1; i >= index; i--)
      data[i + 1] = data[i];
    // Insert new element to data[index]
    data[index] = e;
    // Increase size by 1
    size++;
  }

  public boolean contains(Object e) {
    for (int i = 0; i < size; i++)
      if (e.equals(data[i])) return true;
    return false;
  }

  public E get(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException
        ("Index: " + index + ", Size: " + size);
    return data[index];
  }
  
  public E remove(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException
        ("Index: " + index + ", Size: " + size);
    E e = data[index];
    // Shift data to the left
    for (int j = index; j < size - 1; j++)
      data[j] = data[j + 1];
    data[size - 1] = null; // This element is now null
    // Decrement size
    size--;
    return e;
  }

  public String toString() {
    String result=" ";
    for (int i = 0; i < size; i++) {
      result+= data[i];
      if (i < size - 1) result+=", ";
    }
    return result.toString() + "]";
  }

  
  public int size() {
    return size;
  }
  
 public boolean sortList() {
    E hold;
    for (int i = 0; i < size-1; i++)
     {
       for (int j = 0; j<size-1; j++)
        {       
         if(((Comparable)data[j]).compareTo(data[j+1])>0)
          {
           hold= data[j+1];
           data[j+1]=data[j];
           data[j]=hold;
          }       
       }
     } 
     return true;          
  }
  public void swap(int i, int j) {
    if (i < 0 || j < 0 || i >= size || j >= size) {
        throw new IndexOutOfBoundsException("Invalid indices for swap");
    }
    E temp = data[i];
    data[i] = data[j];
    data[j] = temp;
}
public void shuffleWord() {
    Random rand = new Random();
    for (int i = size - 1; i > 0; i--) {
        int j = rand.nextInt(i + 1); 
        swap(i, j);
    }
}
public void verifyWord(MyArrayList<E> guessedWord) {
    int minSize = Math.min(this.size, guessedWord.size());
    for (int i = 0; i < minSize; i++) {
        E originalElem = this.get(i);
        E guessElem = guessedWord.get(i);

        if (originalElem.equals(guessElem)) {
            if (originalElem instanceof WrapperClass) {
                ((WrapperClass) originalElem).showletter();
            }
        }
    }
}



 
}