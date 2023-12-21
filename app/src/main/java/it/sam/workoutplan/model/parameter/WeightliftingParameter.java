package it.sam.workoutplan.model.parameter;

import it.sam.workoutplan.enumerator.Category;

public interface WeightliftingParameter extends Parameter{

    default Category getCategory(){
        return Category.WEIGHTLIFTING;
    }
}
