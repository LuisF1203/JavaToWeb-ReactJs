# JavaToWeb-ReactJs

# JavaToWebApi

JavaToWebApi is a library that allows you to generate a web API from Java code.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Contributing](#contributing)
- [License](#license)

## Installation

To use JavaToWebApi, you need to include the library in your Java project. You can download the library from [here]([https://example.com/javatowebapi](https://github.com/LuisF1203/JavaToWeb-ReactJs/archive/refs/heads/master.zip)) and add it to your project's dependencies.

## Usage

To use JavaToWebApi, you need to follow these steps:

1. Import the JavaToWebApi library into your Java project.
2. Instantiate the JavaToWebApi class with the desired API name.
3. Use the provided methods to generate HTML elements and tags.
4. Call the necessary methods to apply styles and define routes.
5. Build and deploy your web API.

Here's an example of how to use JavaToWebApi:

```java
import org.example.Api.JavaToWebApi;

public class MyApi {

    public static void main(String[] args) throws IOException {
        JavaToWebApi web = new JavaToWebApi( "macaco");

        web.createApp();
        web.createNewRoute("*", "NotFound");
        web.route("NotFound", "main",
                web.h1("title", "LO LAMENTO :(") +
                        web.div("container", web.a("back", "/", "regresar"))
        );
        web.route("Home", "main",
                        web.div("container",
                                web.h1("title", "Bienvenido a JavaToWeb") +
                                        web.div("mySocials", web.a("socialGithub", "https://github.com/LuisF1203", "ver github"))
                        ));
        web.dev();
         
    }
}
```

This code will generate a div element containing a header and a paragraph. You can further customize the generated HTML elements by using the available methods in the JavaToWebApi class.

## Features

- Generate HTML elements and tags
- Apply styles to HTML elements
- Define routes for navigation
- Create a web API from Java code

## Contributing

Contributions to JavaToWebApi are welcome! If you would like to contribute, please fork the repository and submit a pull request with your changes.

## License

JavaToWebApi is licensed under the [MIT License](https://opensource.org/licenses/MIT).

## Contact

For any questions or suggestions, please feel free to contact me at [luis.montes@iteso.mx](mailto:luis.montes@iteso.mx).
