@Navigation
Feature: Navigation
    To see the subpages
    Without logging in
    I can click the navigation bar links

    Background: I am on the Free Range Testers Web without logging in
        Given I navigate to www.freerangetesters.com

    Scenario Outline: I can access the subpages through the navigation bar
        When I go to <section> using the navigation bar

        Examples:
            | section    |
            | Academia   |
            | Cursos     |
            | Mentorías  |
            | Talleres   |
            | Blog       |
            | Recursos   |

    @Courses
    Scenario: Courses are presented correctly to potential customers
        When I go to Cursos using the navigation bar
        And I select Introducción al Testing de Software
        Then I should see the page with the title "Introducción al Testing de Software"


    @Plans #@Courses
    Scenario: Users can select a plan when they click on "Empezar hoy"
        When I go to Academia using the navigation bar
        And I select the "Empezar hoy" button
        Then The user can see the options mensual and anual
