//          Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
//        используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//        Если значение null, то параметр не должен попадать в запрос.
//        Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//
//

package org.example;public class Main {
    public static void main(String[] args) {
        String str1 = "select * from students where";
        String str2 = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

        String[] strings2 = str2
                .replace("}", "")
                .replace("{", "")
                .replaceAll("\"", "")
                .split(",");
        StringBuilder builder = new StringBuilder(str1).append(" ");

        for (int i =0; i < strings2.length; i++) {
            String[] arrData = strings2[i].split(":");
            if(!arrData[1].equals("null")) {
                if (i != 0) {
                    builder.append(" AND ");
                    builder.append(arrData[0]);
                    builder.append(" = ");
                    builder.append("'");
                    builder.append(arrData[1]);
                    builder.append("'");
                } else {
                    builder.append(arrData[0]);
                    builder.append(" = ");
                    builder.append("'");
                    builder.append(arrData[1]);
                    builder.append("'");

                }


            }



        }

        System.out.println(builder);
    }

}