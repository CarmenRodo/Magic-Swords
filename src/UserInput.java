
public class UserInput {
    private String name;
    private String magicItem;
    private String physItem;

    public int checkName(String name){
        if(name == null || name.isBlank()){
            return 1;
        }
        else{
            return 0;
        }
    }

    public int checkChoice(String choice){
        if(choice == null || choice.isBlank()){
            return 0;
        }
        else{
            if(choice.equals("1")){
                return 1;
            }
            else if(choice.equals("2")){
                return 2;
            }
            else if(choice.equals("3")){
                return 3;
            }
        }
        return 0;
    }
}
