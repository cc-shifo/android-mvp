# android-mvp-demo

This a demo about MVP architechture<br>

### android mvp
android MVP model<br>
![](https://github.com/cc-shifo/android-mvp/raw/master/MVPDemo/mvp模型.png)<br>

### `Demonstration`<br>
![](https://github.com/cc-shifo/android-mvp/raw/master/MVPDemo/mvp-demo.gif)<br>

### directory anotation
#### model
* ArticlesHandler and Article
>Used to simulate to get model data<br>
* ArticleAPI<T>
>It is a interface, which'll be implemented by model self through ArticleAPIImpl. The presenter contain a reference to this interface.
* DataListener
>Reflect the final result of getting model data to View through presenter's api. It is implemented in presenter.

#### view
* ArticlesFragment
>Act as view, and contains a reference to peresenter. This fragment should implement the view interface named ArticleViewInterface, which will be transfered into presenter constructor. The connection between View and Presenter is
built after presenter constructed in fragment.
