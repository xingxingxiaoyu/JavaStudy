package art.recommend; 
 
public class UserRecommendImpl extends BaseRecommend { 
    @Override 
    protected void maturityChange(int grade) { 
 
    } 
 
    @Override 
    protected int preferenceMatchIndex(int index, double otherDisplay, float match) { 
        double display = preferenceDisplay[index]; 
 
        return 0; 
    } 
} 
