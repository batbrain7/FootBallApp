package com.example.mohitkumar.footballapp.di.modules;

import dagger.Module;

@Module(includes = {
        AndroidModule.class,
        ModelModule.class,
        NetworkModule.class,
        ViewModelModule.class
})
public class AppModule {

}
