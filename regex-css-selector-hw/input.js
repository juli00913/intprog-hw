regExps = {
"exercise_1": /[A-Z][a-z]+/,
"exercise_2": /088[^0]\d{6}/,
"exercise_3": /[^01]+/,
"exercise_4": /^[a-zA-Z0-9._]{3,14}$/,
"exercise_5": /1[0-4]\d{2}|1500|^\d{3}$/,
"exercise_6": /class=(\"|\').*(\"|\')/
};
cssSelectors = {
"exercise_1": "item > java",
"exercise_2": "different > java",
"exercise_3": "item > java > tag",
"exercise_4": "#someId + item",
"exercise_5": "tag > java + java.class1",
"exercise_6": "item#someId item > item > item > item",
"exercise_7": "different > different:last-child > java:last-child",
"exercise_8": "#someId"
};
