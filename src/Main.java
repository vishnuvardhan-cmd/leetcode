import com.sun.security.jgss.GSSUtil;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Main {

// Java program to find first and last occurrence of
// an elements in given sorted arra



        public static void main(String[] args)
        {
//
//            int[] a={3,3,1,3,5,2,6,3,5,7,9,2,1};
//            int smallest=stream(a).sorted().findFirst().getAsInt();
//            int largest=stream(a).boxed().sorted(Comparator.reverseOrder()).findFirst().get();
//            System.out.println(largest+" "+smallest);
            Main m=new Main();
//            m.duplicateElements();
//            m.groupingWithOutSorting(new int[]{1,0,1,0,0,0,1,1,1,0});
            m.arraysGroupingWithoutUsinginbuiltMethods(new int[]{3,7,12,30,35},new int[]{5,8,10,15});
        }

        public void replacingAString(String s){
            /*
            sample input   String s="242#$@^@TQR@!#!$!@TVAVAF!R!";
             */
            String s1=s.replaceAll("[^a-zA-Z0-9]","");
            System.out.println(s1);
        }

        public void reversingANumber(){
            int m=143;
            int reverse=0;
            while(m!=0){
                int r=m%10;
                reverse=reverse*10+r;
                m=m/10;
            }
            System.out.println("reverse a number:"+reverse);
        }

        public void findMissingElement(){
            int[] a={-3,5,2,4,20,-1,-3};
            Arrays.sort(a);
            stream(a).boxed().collect(Collectors.toSet());
            System.out.println(a);
            for(int i=0;i<a.length;i++){
                if(a[i]<0 && i+1<a.length){
                    if(a[i]==-1) {
                        if (!(a[i + 1] == 1)) {
                            System.out.println("missing element is : 1");
                            break;
                        }
                    }
                    if(a[i+1]==(a[i]+1)){
                        continue;
                    }
                    else {
                        System.out.println("missing element"+(a[i]+1));
                        break;
                    }
                }
                else  if(a[i]>0 && i+1<a.length){
                    if(a[i]==(a[i+1]-1)){
                        continue;
                    }
                    else{
                        System.out.println("missing element : "+ (a[i+1]-1));
                        break;
                    }
                }
            }
        }

        public void duplicateElements(){
            int[] arr={2,1,1,4,1,3,5,2,4,2,52,63,6,3,2,5,3};
            List<Map.Entry<Integer, Long>> data = stream(arr).boxed().
                    collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream().filter(x -> x.getValue() > 1).collect(Collectors.toList());
            System.out.println(data);
            List<Integer> list= stream(arr).boxed().collect(Collectors.toList());
            System.out.println("option 2 : "+stream(arr).boxed().
                    filter(x->Collections.frequency(list,x)==1).collect(Collectors.toList()));
            List<String> str=Arrays.asList("java","python","mongo","sql","oracle","plsql","python","mongo","sql");
            System.out.println(str.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
        }

        public void groupingWithOutSorting(int[] arr){

            List<Integer> list=new LinkedList<>();
            list.addAll(Arrays.stream(arr).boxed().filter(x->x==0).collect(Collectors.toList()));
            list.addAll(Arrays.stream(arr).boxed().filter(x->x==1).collect(Collectors.toList()));
            System.out.println(list);
//            Arrays.stream(arr).boxed().filter(x->x==0).collect(Collectors.toList());


        }

        public void arraysGroupingWithoutUsinginbuiltMethods(int a[],int b[]){
            int i=0,j=0;
            int max=a.length>b.length?a.length:b.length;
            int[] newArr=new int[a.length+b.length];
//            Arrays.stream(a).boxed().map(x->{
//
//            })

            for(int a1:a){
                if(j<b.length-1) {
                    if (a1 < b[j]) {
                        newArr[i] = a1;
                    }
                }
                if(i<a.length-1) {
                  if(b[j]<a1){
                        newArr[i] = b[j];
                    }
                }

                i++;
                j++;
            }
            System.out.println(newArr.toString());
        }

}