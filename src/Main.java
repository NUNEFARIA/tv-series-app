import service.TvMazeAPIService;

public class Main {
    
    public static void main(String[] args) {
        
        try {
            
            TvMazeAPIService api =
                    new TvMazeAPIService();
            
            String json =
                    api.searchByName("Breaking Bad");
            
            System.out.println(json);
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
        
    }
    
}