package com.example.testsdemo;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class InputFieldTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void checkClick() {
        // type 5 value in first EditText
        onView(withId(R.id.first_operand))
                .perform(typeText("5"));

        // press addition button
        onView(withId(R.id.add_button))
                .perform(click());

        // check that TextView contains error text
        onView(withId(R.id.text_result))
                .check(matches(withText(R.string.empty_operands)));
    }

    @Test
    public void checkSum() {
        // type 5 value in first EditText
        onView(withId(R.id.first_operand))
                .perform(typeText("5"));

        onView(withId(R.id.second_operand))
                .perform(typeText("10"));

        // press addition button
        onView(withId(R.id.add_button))
                .perform(click());

        // check that TextView contains error text
        onView(withId(R.id.text_result))
                .check(matches(withText("15.0")));
    }
}
