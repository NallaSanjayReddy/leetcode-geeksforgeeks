class Solution {
    public String[] shortestSubstrings(String[] arr) {
        String ans[]=new String[arr.length];
        TreeSet<String> tree;
        for(int i=0;i<arr.length;i++){
            int l=0;
            int r=arr[i].length()-1;
            tree=new TreeSet(new Comparator<String>(){
                @Override
                public int compare(String a, String b){
                    if(a.length()>b.length()) return 1;
                    else if(a.length()<b.length()) return -1;
                    else{ 
                        if(a.compareTo(b)>0) return 1;
                        if(a.compareTo(b)<0) return -1;
                        else return 0;
                    }
                }
            });
            addsubstr(arr,tree,i,l,r);
            System.out.println(tree);
            if(tree.size()==0) ans[i]="";
            else ans[i]=tree.pollFirst();
            
        }
        return ans;
        
    }
    public void addsubstr(String arr[],TreeSet<String> tree, int i, int l, int r){
        if(l<=r && !tree.contains(arr[i].substring(l,r+1))){
            boolean isthere=false;
            for(int j=0;j<arr.length;j++){
                if(j!=i && arr[j].indexOf(arr[i].substring(l,r+1))!=-1){
                    isthere=true;
                    break;
                }
            }
            if(isthere==false){
                tree.add(arr[i].substring(l,r+1));
            }
            addsubstr(arr,tree,i,l+1,r);
            addsubstr(arr,tree,i,l,r-1);
        }
    }
}

