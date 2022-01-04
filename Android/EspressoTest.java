package espresso;
//get the imports right
import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyLeftOf;
import static androidx.test.espresso.assertion.PositionAssertions.isLeftOf;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.leecottrell.stathelper.MainActivity;
import com.leecottrell.stathelper.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspressoTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void numberIsDisplayedBesideEditBox() {
        onView(withText("Number")).check(matches(isDisplayed()));
        onView(withText("Number")).check(isCompletelyLeftOf(withId(R.id.editNumItems)));
    }

    @Test
    public void permutationWithNoRepIsCorrect(){
        //fill the text areas
        onView(ViewMatchers.withId(R.id.editNumItems)).perform(ViewActions.typeText("5"));
        onView(withId(R.id.editNumReps)).perform(ViewActions.typeText("3"));
        onView(withId(R.id.buttonPermRep)).perform(ViewActions.click());
        String expected = "125";
        onView(withId(R.id.textResponse)).check(matches(withText("Permutations with repetition")));
        onView(withId(R.id.textAnswer)).check(matches(withText(expected)));
    }
}