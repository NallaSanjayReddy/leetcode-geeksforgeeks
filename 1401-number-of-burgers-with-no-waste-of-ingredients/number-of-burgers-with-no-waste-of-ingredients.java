class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ans=new ArrayList<>();
        if(tomatoSlices==0 && cheeseSlices==0){
            ans.add(0);
            ans.add(0);
            return ans;
        }
        if(tomatoSlices==0 || cheeseSlices==0) return ans;
        if(tomatoSlices<=cheeseSlices) return ans;
        if(tomatoSlices%2!=0) return ans;
        if((tomatoSlices/cheeseSlices)>4 || (tomatoSlices/cheeseSlices)<2) return ans;
        int total_jumbo=(tomatoSlices/2)-cheeseSlices;
        int total_small=cheeseSlices-total_jumbo;
        if(total_jumbo<0 || total_small<0){
            return ans;
        }
        ans.add(total_jumbo);
        ans.add(total_small);
        return ans;

    }
}