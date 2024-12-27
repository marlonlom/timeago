# Languages supported

TBD

## Adding a new language
Ensure that your code adheres to the existing style in the sample to which you are contributing.

1. Fork the repository.

2. Create a copy of the `messages.properties` default file, which is found in the `src/main/resources` folder of
   the `ta_library` library module.

3. Rename the properties file using the desired language code as suffix, for example, if the language is Catalan, the
   filename would be `messages_ca.properties` as the language code for that language is 'ca'. You can see a list of the
   available ISO language codes table [here](http://www.lingoes.net/en/translator/langcode.htm).

4. Inside the new properties file, which contains key=value pairs, modify the translation (property value) for the
   selected language, maintaining the property key as it is.

5. After editing the new language properties file, run the unit tests inside `ta_library` library module, ensuring the
   translations are working successfully. Keep in mind that the unit tests that exists runs using random selected
   language, so, you can test it for the selected language adding the language code in the DataBuilder object which is
   found in the unit tests base package inside `ta_library` library module.

6. Once the unit tests are working in the `ta_library` library module, run the android sample application
   module `ta_sample`, which uses the library, and check that the texts are displaying successfully.

7. Finally, if everything is working, submit a pull request with a detailed explanation about the new language.

## Supported languages table

| **ISO 639-1 Code** | **Name**         | **Default** | **Credits**                                        |
|--------------------|------------------|:-----------:|----------------------------------------------------|
| AR                 | Arabic           |             | [Mohamed Helmy](https://github.com/mohamed-helmy)  |
| CS                 | Czech            |             | [Martin Macko](https://github.com/LinkedList)      |
| DA                 | Danish           |             | [soelling](https://github.com/soelling)            |
| DE                 | German           |             |                                                    |
| EN                 | English          |      Y      |                                                    |
| ES                 | Spanish          |             |                                                    |
| EU                 | Basque           |             | [Sendoa Portuondo](https://github.com/sportuondo)  |
| FA                 | Farsi            |             | [Amir Hossein Ghasemi](https://github.com/amirghm) |
| FR                 | French           |             | [Olivier Perez](https://github.com/olivierperez)   |
| HI                 | Hindi            |             | [qsyogesh](https://github.com/qsyogesh)            |
| HU                 | Hungarian        |             | [Sándor Uszkai](https://github.com/uszkaisandor)   |
| IN                 | Indonesian       |             | [Irsal Shabirin](https://github.com/irsalshabirin) |
| IT                 | Italian          |             |                                                    |
| NL                 | Dutch; Flemish   |             | [Pieter De Clercq](https://github.com/thepieterdc) |
| PL                 | Polish           |             | [John McKean](https://github.com/johnpaulmckean)   |
| PT                 | Portuguese       |             |                                                    |
| TR                 | Turkish          |             | [Kadir Caner](https://github.com/kadircanerergun)  |
| ZH                 | Chinese          |             | [Yuanuo](https://github.com/Yuanuo)                |
| ZH-TW              | Chinese (Taiwan) |             | [Yuanuo](https://github.com/Yuanuo)                |
