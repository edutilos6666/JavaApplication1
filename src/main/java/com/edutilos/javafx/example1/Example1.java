package com.edutilos.javafx.example1;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by edutilos on 19/02/2017.
 */
public class Example1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        //line
    /*    Line line = new Line();
        line.setStartX(10);
        line.setStartY(10);
        line.setEndX(100);
        line.setEndY(150);
        root.getChildren().add(line);*/

        //text
     /*   Text  text = new Text("Hello World");
        text.setX(10);
        text.setY(200);
        text.setFont(new Font(45));
        root.getChildren().add(text);*/

        //rectangle
      /*  Rectangle rect = new Rectangle();
        rect.setX(10);
        rect.setY(10);
        rect.setWidth(100);
        rect.setHeight(50);
        rect.setStroke(Color.YELLOW);
        rect.setFill(Color.GREEN);
        root.getChildren().add(rect);*/

        //rounded rectangle
   /*     Rectangle rect = new Rectangle();
        rect.setX(10);
        rect.setY(10);
        rect.setWidth(200);
        rect.setHeight(100);
        rect.setArcWidth(30);
        rect.setArcHeight(20);
        root.getChildren().add(rect);*/

        //circle
      /*  Circle circle = new Circle();
        circle.setCenterX(250);
        circle.setCenterY(250);
        circle.setRadius(200);
        root.getChildren().add(circle);*/


        //ellipse
       /* Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(250);
        ellipse.setCenterY(250);
        ellipse.setRadiusX(150);
        ellipse.setRadiusY(100);
        root.getChildren().add(ellipse);*/

        //polygon
   /*     Polygon polygon = new Polygon();
        Double [] points = new Double[]{
                200.0, 50.0,
                400.0, 50.0,
                450.0, 150.0,
                400.0, 250.0,
                200.0, 250.0,
                150.0, 150.0,
        };
        polygon.getPoints().addAll(points);
        root.getChildren().add(polygon); */


        //polyline
    /*    Polyline polyline = new Polyline();
        Double [] points = new Double[]{
                200.0, 50.0,
                400.0, 50.0,
                450.0, 150.0,
                400.0, 250.0,
                200.0, 250.0,
                150.0, 150.0,
        };

        polyline.getPoints().addAll(points);
        root.getChildren().add(polyline); */

/*
        (108 , 71)
        (232 , 52)
        (321, 161)
        (269, 250)
        (126 , 232)*/

   /*     MoveTo moveTo = new MoveTo(108 , 71);
        LineTo line1 = new LineTo(232, 52);
        LineTo line2 = new LineTo(321, 161);
        LineTo line3 = new LineTo(269, 250);
        LineTo line4 = new LineTo(126, 232);
        LineTo line5 = new LineTo(108 , 71);
        Path path = new Path(moveTo, line1, line2, line3, line4, line5);
        root.getChildren().add(path);*/


        //text examples
       /* Text txt1 , txt2 , txt3 ;
        txt1 = new Text("Hello World text1");
        txt1.setStrokeWidth(3);
        txt1.setFill(Color.RED);
        txt1.setStroke(Color.BLACK);
        txt1.setX(10);
        txt1.setY(100);
        txt1.setFont(new Font(60));

        txt2 = new Text("Hello World text2");
        txt2.setStrokeWidth(3);
        txt2.setFill(Color.GREEN);
        txt2.setStroke(Color.BLACK);
        txt2.setX(10);
        txt2.setY(200);
        txt2.setFont(new Font(60));
        txt2.setStrikethrough(true);


        txt3 = new Text("Hello World text3");
        txt3.setStrokeWidth(3);
        txt3.setFill(Color.YELLOW);
        txt3.setStroke(Color.BLACK);
        txt3.setX(10);
        txt3.setY(300);
        txt3.setFont(new Font(60));
        txt3.setUnderline(true);
        root.getChildren().addAll(txt1, txt2, txt3);*/


         //ImageView
    /*    Image image = new Image("https://www.tutorialspoint.com/green/images/logo.png");
        ImageView imageView = new ImageView(image);
        imageView.setX(100);
        imageView.setY(100);
        imageView.setFitWidth(300);
        imageView.setFitHeight(200);
        //effect
        Glow glow = new Glow();
        glow.setLevel(0.9);
        Shadow shadow = new Shadow();
        shadow.setColor(Color.RED);


        imageView.setEffect(shadow);


        root.getChildren().add(imageView);*/

        //transform
/*        Rectangle rect1 , rect2 ;
        rect1 = new Rectangle();
        rect1.setX(100);
        rect1.setY(100);
        rect1.setWidth(400);
        rect1.setHeight(300);
        rect1.setFill(Color.RED);

        rect2 = new Rectangle();
        rect2.setX(100);
        rect2.setY(100);
        rect2.setWidth(400);
        rect2.setHeight(300);
        rect2.setFill(Color.GREEN);
        Rotate rotate = new Rotate();
        rotate.setAngle(20);
        rotate.setPivotX(200);
        rotate.setPivotY(200);
        rect2.getTransforms().addAll(rotate);


        root.getChildren().addAll(rect1, rect2);*/

   /*     VBox vb = new VBox();
        vb.setTranslateX(100);
        vb.setTranslateY(100);
        Rectangle rect = new Rectangle(200, 200, 300, 300);
        vb.getChildren().addAll(rect);
        Rotate rotate = new Rotate(20, 100, 100);
        root.getTransforms().addAll(rotate);
        vb.setSpacing(100);

        root.getChildren().addAll(vb);

        HBox hbControllers = new HBox();
        Button btnRotate , btnScale , btnTranslate ;
        btnRotate = new Button("Rotate");
        btnScale = new Button("Scale");
        btnTranslate = new Button("Translate");
      hbControllers.getChildren().addAll(btnRotate, btnScale, btnTranslate);
        hbControllers.setSpacing(20);
        hbControllers.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(hbControllers);



        final double  [] angle = new double[] {20} ;

        EventHandler<MouseEvent> handlerRotate = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Rotate rot =  new Rotate(angle[0], 100, 100);
                angle[0] += 10 ;
               // rect.getTransforms().clear();
                rect.getTransforms().addAll(rot);
            }
        };

        // EventHandler<MouseEvent>

        btnRotate.addEventHandler(MouseEvent.MOUSE_CLICKED, handlerRotate);






          double [] scaleFactor = new double []{1.1};
        EventHandler<MouseEvent> handleScale = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Scale scale = new Scale(scaleFactor[0], scaleFactor[0]);
                scaleFactor[0] += 0.1 ;
                rect.getTransforms().addAll(scale);
            }
        };
       btnScale.addEventHandler(MouseEvent.MOUSE_CLICKED, handleScale);

        final double [] translates = {10, 5};
        EventHandler<MouseEvent> handlerTranslate = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Translate translate = new Translate(translates[0], translates[1]);
                translates[0]+= 10 ;
                translates[1]+= 5 ;
                rect.getTransforms().addAll(translate);
            }
        };

        btnTranslate.addEventFilter(MouseEvent.MOUSE_CLICKED, handlerTranslate);
*/



        //3d example
/*        Box box = new Box();
        box.setWidth(300);
        box.setHeight(300);
        box.setDepth(300);
        Translate translate = new Translate();
        translate.setX(400);
        translate.setY(150);
        translate.setZ(25);

        Rotate rxBox = new Rotate(0, 0, 0, 0, Rotate.X_AXIS);
        Rotate ryBox = new Rotate(0, 0, 0, 0, Rotate.Y_AXIS);
        Rotate rzBox = new Rotate(0, 0, 0, 0, Rotate.Z_AXIS);
        rxBox.setAngle(30);
        ryBox.setAngle(50);
        rzBox.setAngle(30);
        box.getTransforms().addAll(translate, rxBox, ryBox, rzBox);

        root.getChildren().add(box);*/


        //FillTransition
        Rectangle rect = new Rectangle(100, 100, 200, 300);
        root.getChildren().add(rect);
   /*     FillTransition tr1 = new FillTransition();
        tr1.setShape(rect);
        tr1.setDuration(Duration.millis(10000));
        tr1.setFromValue(Color.RED);
        tr1.setToValue(Color.GREEN);
        tr1.setAutoReverse(true);
        tr1.setCycleCount(50);
        tr1.play();

        //FadeTransition
        FadeTransition tr = new FadeTransition(Duration.millis(3000), rect);
        tr.setCycleCount(4);
        tr.setAutoReverse(true);
        tr.setFromValue(1);
        tr.setToValue(0.3);
        tr.play();*/

        //ParallelTransition
   /*     FillTransition tr1 = new FillTransition();
       // tr1.setShape(rect);
        tr1.setDuration(Duration.millis(2000));
        tr1.setFromValue(Color.RED);
        tr1.setToValue(Color.GREEN);
        tr1.setAutoReverse(true);
        tr1.setCycleCount(50);
        //tr1.play();

        //FadeTransition
        FadeTransition tr = new FadeTransition(Duration.millis(3000));
        tr.setCycleCount(4);
        tr.setAutoReverse(true);
        tr.setFromValue(1);
        tr.setToValue(0.3);
        //tr.play();

        ParallelTransition pltr = new ParallelTransition(rect, tr1, tr);
        pltr.play();*/


        //ScaleTransition
      /*  ScaleTransition tr = new ScaleTransition(Duration.millis(2000), rect);
        tr.setByX(2);
        tr.setByY(2);
        tr.setCycleCount(4);
        tr.setAutoReverse(true);
        tr.play();*/

/*
// TranslateTransition
        TranslateTransition tr = new TranslateTransition(Duration.millis(2000), rect);
        tr.setByX(200);
        tr.setByY(100);
        tr.setCycleCount(4);
        tr.setAutoReverse(true);
        tr.play();
*/

         //PathTransition
    /*    rect.setTranslateX(100);
        rect.setTranslateY(200);
        Path path = new Path();
          path.getElements().add (new MoveTo (0f, 50f));
       path.getElements().add (new CubicCurveTo (40f, 10f, 390f, 240f, 1904, 50f));
        PathTransition tr = new PathTransition(Duration.millis(2000), path , rect);
        tr.setCycleCount(4);
        tr.setAutoReverse(true);
        tr.play();*/

        Scene scene = new Scene(root, 500, 500);
        scene.setFill(Color.BLUE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("First Simple Application");
        primaryStage.show();
    }
}
