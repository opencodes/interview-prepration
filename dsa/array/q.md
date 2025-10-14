
In cooking terms, recipe is a prep-list combination of ingredients if you can prepare it by mixing together the first several ingredients from your list, one after another, starting from the very beginning. More formally, string recipe is a prep-list combination of array of strings ingredients if there is some index i≥ 0 such that recipe = ingredients [0] + ingredients [1] +
+ ingredients [i]

For example, consider an array ingredients =
["flour", "sugar" "eggs"]

RULES
• recipe =
= recipe = "flour"
"flour" is a prep-list combination of the ingredients array, as ingredients [0]
·
recipe = "flour sugar" is a prep-list combination of the ingredients array, as = "floursugar"
INFO
ingredients [0] + ingredients [1] recipe =
· recipe =
*
SETTINGS
,
"floursug" is not a prep-list combination of the ingredients array, · recipe = "floureggs" is not a prep-list combination of the ingredients array.
Task: Given two arrays of ingredients ingredients and recipes, for each recipe in recipes, find out whether it is a prep-list combination of ingredients . As a result, returr array of length recipes.length, where the ith element is true if recipes [i] is a pre list combination of ingredients, and false otherwise.

Note: You are not expected to provide the most optimal solution, but a solution with time complexity not worse than o (ingredients.length2 × recipes.length) will fit within the execution time limit.
Time's up!
The session is over.
 
For ingredients = ["flour", "sugar", "eggs"] and 
recipes ["floursugar","random", "flour" , "sugarflour", "sugareggs"]

the output should be  [true, false, true, false, false] 