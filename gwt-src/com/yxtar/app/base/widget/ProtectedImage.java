package com.yxtar.app.base.widget;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * PreloadImage an image widget which can resize the image without change the
 * image size ratio, it also support image preload
 * @author jimmylo
 * 
 */
public class ProtectedImage extends PreloadImage {
  private FlowPanel simplePanel = new FlowPanel();
  private SimplePanel protectPanel = new SimplePanel();
  /**
   * Constructor
   * @param url image url
   * @param width image display width
   * @param height image display height
   */
  public ProtectedImage(String url, int width, int height) {
    this(url, width, height, true);
  }

  /**
   * Constructor
   * @param url image url
   * @param width image display width
   * @param height image display height
   * @param preloadFlg true for start preloading and showing the image
   */
  public ProtectedImage(String url, int width, int height, boolean preloadFlag) {
    super(url, width, height,false);
    mainPanel.add(simplePanel);
    protectPanel.getElement().getStyle().setPosition(Position.RELATIVE);
    protectPanel.getElement().getStyle().setLeft(0, Unit.PX);
    protectPanel.getElement().getStyle().setTop(0, Unit.PX);
    simplePanel.getElement().getStyle().setOverflow(Overflow.HIDDEN);
    protectPanel.getElement().getStyle().setZIndex(1);
    preloadFlg=true;
    if (preloadFlg) {
      this.preLoadImageByUrl(url);
    }
  }

  /**
   * preload and show image by provided image url path
   * @param url image url path
   */
  public void preLoadImageByUrl(String url) {
    image = new Image(url);
    for (int i = 0; i < this.mouseOverHandlers.size(); i++) {
      image.addMouseOverHandler(this.mouseOverHandlers.get(i));
    }
    for (int i = 0; i < this.cliskHandlers.size(); i++) {
      image.addClickHandler(this.cliskHandlers.get(i));
    }
    for (int i = 0; i < this.mouseOverHandlers.size(); i++) {
      protectPanel.addDomHandler(this.mouseOverHandlers.get(i), MouseOverEvent.getType());
    }
    for (int i = 0; i < this.cliskHandlers.size(); i++) {
      protectPanel.addDomHandler(this.cliskHandlers.get(i), ClickEvent.getType());
    }
    image.addLoadHandler(new LoadHandler() {

      Image preloadImage = image;

      public void onLoad(LoadEvent arg0) {
        int offsetWidth = preloadImage.getOffsetWidth();
        int offsetHeight = preloadImage.getOffsetHeight();
        originalheight = offsetHeight;
        originalWidth = offsetWidth;

        /*
         * calculate new image width and height for resizing without affecting
         * the image scale
         */
        int finalWidth = 0;
        int finalHeight = 0;
        if (offsetWidth == offsetHeight) {
          if (width > height) {
            finalWidth = height;
            finalHeight = height;
          } else {
            finalWidth = width;
            finalHeight = width;
          }
        } else if (width > height) {
          if (offsetWidth > offsetHeight) {
            if (offsetWidth * 1000 / offsetHeight - width * 1000 / height > 0) {
              finalWidth = width;
              finalHeight = width * offsetHeight / offsetWidth;
            } else {
              finalWidth = height * offsetWidth / offsetHeight;
              finalHeight = height;
            }
          } else {
            finalWidth = height * offsetWidth / offsetHeight;
            finalHeight = height;
          }
        } else {
          if (offsetWidth > offsetHeight) {
            finalWidth = width;
            finalHeight = width * offsetHeight / offsetWidth;
          } else {
            if (offsetHeight * 1000 / offsetWidth - height * 1000 / width > 0) {
              finalWidth = height * offsetWidth / offsetHeight;
              finalHeight = height;
            } else {
              finalWidth = width;
              finalHeight = width * offsetHeight / offsetWidth;
            }
          }
        }
        preloadImage.setPixelSize(finalWidth, finalHeight);
        // remove the image from preload panel after preloading completed
        preloadImage.removeFromParent();

        simplePanel.clear();
        // add the preloaded image to main panel
        simplePanel.add(protectPanel);
        simplePanel.add(preloadImage);
        protectPanel.setSize(finalWidth + Unit.PX.getType(), finalHeight + Unit.PX.getType());
        simplePanel.setSize(finalWidth + Unit.PX.getType(), finalHeight + Unit.PX.getType());
        preloadImage.getElement().getStyle().setPosition(Position.RELATIVE);
        preloadImage.getElement().getStyle().setLeft(0, Unit.PX);
        preloadImage.getElement().getStyle().setTop(-finalHeight, Unit.PX);
        preloadPanel.hide();
        // add event for tell others about the end of image loading
        for (int i = 0; i < preloadImageEventHandlers.size(); i++) {
          preloadImageEventHandlers.get(i).onLoadCompleted();
        }
      }
    });

    // add the image to preloadPanel for starting the loading process
    preloadPanel.clear();
    preloadPanel.add(image);
    preloadPanel.show();
    // preloadImageEventHandlers.clear();
  }

  public void addMouseOverHandler(MouseOverHandler mouseOverHandler) {
    super.addMouseOverHandler(mouseOverHandler);
    if (this.mouseOverHandlers != null && protectPanel != null) {
      this.mouseOverHandlers.add(mouseOverHandler);
      for (int i = 0; i < this.mouseOverHandlers.size(); i++) {
        protectPanel.addDomHandler(this.mouseOverHandlers.get(i), MouseOverEvent.getType());
      }
    }
  }

  public void addClickHandler(ClickHandler mouseOverHandler) {
    super.addClickHandler(mouseOverHandler);
    if (this.cliskHandlers != null && protectPanel != null) {
      this.cliskHandlers.add(mouseOverHandler);
      for (int i = 0; i < this.cliskHandlers.size(); i++) {
        protectPanel.addDomHandler(this.cliskHandlers.get(i), ClickEvent.getType());
      }
    }
  }

}
