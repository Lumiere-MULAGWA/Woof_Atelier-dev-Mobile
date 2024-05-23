package com.example.woof.data

class Dog {

    /**
     * Composable that displays an app bar and a list of dogs.
     */
    @Composable
    fun WoofApp() {
        LazyColumn {
            items(dogs) {
                DogItem(dog = it)
            }
        }
    }

    /**
     * Composable that displays a list item containing a dog icon and their information.
     *
     * @param dog contains the data that populates the list item
     * @param modifier modifiers to set to this composable
     */
    @Composable
    fun DogItem(
        dog: Dog,
        modifier: Modifier = Modifier
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            DogIcon(dog.imageResourceId)
            DogInformation(dog.name, dog.age)
        }
    }

    /**
     * Composable that displays a photo of a dog.
     *
     * @param dogIcon is the resource ID for the image of the dog
     * @param modifier modifiers to set to this composable
     */
    @Composable
    fun DogIcon(
        @DrawableRes dogIcon: Int,
        modifier: Modifier = Modifier
    ) {
        Image(
            modifier = modifier
                .size(dimensionResource(R.dimen.image_size))
                .padding(dimensionResource(R.dimen.padding_small)),
            painter = painterResource(dogIcon),

            // Content Description is not needed here - image is decorative, and setting a null content
            // description allows accessibility services to skip this element during navigation.

            contentDescription = null
        )
    }

    /**
     * Composable that displays a dog's name and age.
     *
     * @param dogName is the resource ID for the string of the dog's name
     * @param dogAge is the Int that represents the dog's age
     * @param modifier modifiers to set to this composable
     */
    @Composable
    fun DogInformation(
        @StringRes dogName: Int,
        dogAge: Int,
        modifier: Modifier = Modifier
    ) {
        Column(modifier = modifier) {
            Text(
                text = stringResource(dogName),
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
            Text(
                text = stringResource(R.string.years_old, dogAge),
            )
        }
    }

    Replacer la section de l'anotation preview par le code suivant

    /**
     * Composable that displays what the UI of the app looks like in light theme in the design tab.
     */
    @Preview
    @Composable
    fun WoofPreview() {
        WoofTheme(darkTheme = false) {
            WoofApp()
        }
    }
}