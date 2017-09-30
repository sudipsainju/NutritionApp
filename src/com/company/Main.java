package com.company;
/**
 * Exercise 3 - Nutrition APP
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws Exception {
        firstExercise();
        //secondExercise();
    }

    public static void firstExercise() {

        BufferedReader input = null;
        ArrayList<Recipe> recepieList = new ArrayList<>();

        try {
            //Choose the file that you will use.
            //Read your input and create the Objects Recipe
            input = new BufferedReader(new FileReader("/Users/sudip/IdeaProjects/Word/src/com/company/recepies.txt"));
            boolean ingredient = false;
            boolean step = false;
            String in;
            String name = input.readLine();

            ArrayList<String> ingredients = new ArrayList<>();
            ArrayList <String> steps = new ArrayList<>();

            while (  (in = input.readLine()) != null){

                switch (in) {
                    case "":
                        ingredient = false;
                        step = false;
                        //name = input.readLine();
                        break;
                    case "ingredients:":
                        ingredient = true;
                        step = false;
                        break;
                    case "steps:":
                        ingredient = false;
                        step = true;
                        break;
                    default:
                        if (ingredient) {
                            ingredients.add(in);
                        } else if (step) {
                            steps.add(in);
                        } else {
                            recepieList.add(new Recipe(name, ingredients, steps));
                            ingredients = new ArrayList<>();
                            steps = new ArrayList<>();
                        }
                        break;
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null){
                    input.close();
                }
            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }

        //Print all the objects Recipe that you created.
        for (Recipe recipe : recepieList){
            System.out.println(recipe.toString());
        }

        //Expected output. (Use tab instead of space to give format to the output)
        /*

Crock Pot Roast
    ingredients:
        1 beef roast, Meat
        1 package brown gravy mix, Baking
        1 package dried Italian salad dressing mix, Condiments
        1 package dry ranch dressing mix, Condiments
        1/2 cup water, Drinks
    steps:
        1. Place beef roast in crock pot
        2. Mix the dried mixes together in a bowl and sprinkle over the roast.
        3. Pour the water around the roast.
        4. Cook on low for 7-9 hours.
Roasted asparagus
    ingredients:
        1 lb asparagus, Produce
        1 1/2 tbsp olive oil, Condiments
        1/2 tsp kosher salt, Baking
    steps:
        1. Preheat oven to 425F.
        2. Cut off the woody bottom part of the asparagus spears and discard.
        3. With a vegetable peeler, peel off the skin on the bottom 2-3 inches of the spears.
        4. Place asparagus on foil-lined baking sheet and drizzle with olive oil.
        5. Sprinkle with salt.
        6. With your hands, roll the asparagus around until they are evenly coated with oil and salt.
        7. Roast for 10-15 minutes, depending on the thickness of your stalks and how tender you like them.
        8. They should be tender when pierced with the tip of a knife.
        9. The tips of the spears will get very brown but watch them to prevent burning.
        10. They are great plain, but sometimes I serve them with a light vinaigrette if we need something acidic to balance out our meal.
Curried Lentils and Rice
    ingredients:
        1 quart beef broth, Misc
        1 cup dried green lentils, Misc
        1/2 cup basmati rice, Misc
        1 tsp curry powder, Condiments
        1 tsp salt, Condiments
    steps:
        1. Bring broth to a low boil.
        2. Add curry powder and salt.
        3. Cook lentils for 20 minutes.
        4. Add rice and simmer for 20 minutes.

        */

    }

    public static void secondExercise() {
        //System.out.println(recepieList.get(0));
        try {
            FileOutputStream output = new FileOutputStream("Root/src/favorite_recipe.txt");


            //Write to the file the favorite recipe Crock Pot Roast information to test
            //Use methods of the Object Recipe to generate the amount of ingredients
            //and the amount of steps.



            //Write the favorite recipe to the file


            //Expected action: Save the favorite recipe
            //Use tab instead of space to give format after each new line.
/*
Crock Pot Roast
    ingredients: 5
    steps: 4
*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void thirdExercise() {

        //Read the favorite_recipe.txt file
        //Print what the file "favorite_recipe.txt" has



        //Expected output:

        /*
Crock Pot Roast
    ingredients: 5
    steps: 4
*/

    }
}

class Recipe {
    public ArrayList<String> ingredients, steps;
    public String name;
    public Recipe(String name, ArrayList<String> ingredients, ArrayList<String> steps) {
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public String getIngredients(){
        String result = "";
        for ( String ingredient : ingredients ){
            result = result + "\n\t\t\t" + ingredient;
        }
        return result;
    }

    public String getSteps(){
        String result = "";
        int i = 1;
        for (String step : steps){
            result = result + "\n\t\t\t"+ i + ". " + step;
            i++;
        }
        return result;
    }

    public String toString(){
        return name + "\n\tingredients:\t" + getIngredients() + "\n\tsteps:\t" + getSteps();
    }
}