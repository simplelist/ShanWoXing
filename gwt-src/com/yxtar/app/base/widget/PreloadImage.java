package com.yxtar.app.base.widget;import java.util.ArrayList;import java.util.List;import com.google.gwt.dom.client.Style.Unit;import com.google.gwt.event.dom.client.ClickHandler;import com.google.gwt.event.dom.client.LoadEvent;import com.google.gwt.event.dom.client.LoadHandler;import com.google.gwt.event.dom.client.MouseOverHandler;import com.google.gwt.event.shared.HasHandlers;import com.google.gwt.user.client.Window;import com.google.gwt.user.client.ui.Composite;import com.google.gwt.user.client.ui.HasHorizontalAlignment;import com.google.gwt.user.client.ui.HasVerticalAlignment;import com.google.gwt.user.client.ui.Image;import com.google.gwt.user.client.ui.PopupPanel;import com.google.gwt.user.client.ui.VerticalPanel;import com.yxtar.app.base.event.PreloadImageEventHandler;/** * PreloadImage an image widget which can resize the image without change the * image size ratio, it also support image preload * @author jimmylo *  */public class PreloadImage extends Composite implements HasHandlers {  /**   * a popup panel for preload image usage   */  protected PopupPanel preloadPanel;  protected Image image;  /**   * image url path   */  protected String url;  protected VerticalPanel mainPanel;  protected int width = 0; // image width  protected int height = 0; // image height  protected int originalWidth = 0;  protected int originalheight = 0;  protected List<MouseOverHandler> mouseOverHandlers = new ArrayList<MouseOverHandler>();  protected List<PreloadImageEventHandler> preloadImageEventHandlers;  protected List<ClickHandler> cliskHandlers = new ArrayList<ClickHandler>();  /**   * flag indicating whether the image is preloaded or not   */  protected boolean preloadFlg = true;  /**   * Constructor   * @param url image url   * @param width image display width   * @param height image display height   */  public PreloadImage(String url, int width, int height) {    this(url, width, height, true);  }  /**   * Constructor   * @param url image url   * @param width image display width   * @param height image display height   * @param preloadFlg true for start preloading and showing the image   */  public PreloadImage(String url, int width, int height, boolean preloadFlag) {    this.url = url;    this.width = width;    this.height = height;    this.preloadFlg = preloadFlag;    mainPanel = new VerticalPanel();    initWidget(mainPanel);    mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);    mainPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);    mainPanel.setSize(width + Unit.PX.toString(), height + Unit.PX.toString());    preloadImageEventHandlers = new ArrayList<PreloadImageEventHandler>();    preloadPanel = new PopupPanel();    preloadPanel.getElement().getStyle().setZIndex(-1);    preloadPanel.getElement().getStyle().setOpacity(0);    preloadPanel.hide();    if (this.preloadFlg) {      this.preLoadImageByUrl(url);    }  }  /**   * preload and show image   */  public void preLoadImage() {    this.preLoadImageByUrl(this.url);  }  /**   * preload and show image by provided image url path   * @param url image url path   */  public void preLoadImageByUrl(String url) {    image = new Image(url);    for (int i = 0; i < this.mouseOverHandlers.size(); i++) {      image.addMouseOverHandler(this.mouseOverHandlers.get(i));    }    for (int i = 0; i < this.cliskHandlers.size(); i++) {      image.addClickHandler(this.cliskHandlers.get(i));    }    image.addLoadHandler(new LoadHandler() {      Image preloadImage = image;      public void onLoad(LoadEvent arg0) {        int offsetWidth = preloadImage.getOffsetWidth();        int offsetHeight = preloadImage.getOffsetHeight();        originalheight = offsetHeight;        originalWidth = offsetWidth;        /*         * calculate new image width and height for resizing without affecting         * the image scale         */        int finalWidth = 0;        int finalHeight = 0;        if (offsetWidth == offsetHeight) {          if (width > height) {            finalWidth = height;            finalHeight = height;          } else {            finalWidth = width;            finalHeight = width;          }        } else if (width > height) {          if (offsetWidth > offsetHeight) {            if (offsetWidth * 1000 / offsetHeight - width * 1000 / height > 0) {              finalWidth = width;              finalHeight = width * offsetHeight / offsetWidth;            } else {              finalWidth = height * offsetWidth / offsetHeight;              finalHeight = height;            }          } else {            finalWidth = height * offsetWidth / offsetHeight;            finalHeight = height;          }        } else {          if (offsetWidth > offsetHeight) {            finalWidth = width;            finalHeight = width * offsetHeight / offsetWidth;          } else {            if (offsetHeight * 1000 / offsetWidth - height * 1000 / width > 0) {              finalWidth = height * offsetWidth / offsetHeight;              finalHeight = height;            } else {              finalWidth = width;              finalHeight = width * offsetHeight / offsetWidth;            }          }        }        preloadImage.setPixelSize(finalWidth, finalHeight);        // remove the image from preload panel after preloading completed        preloadImage.removeFromParent();        mainPanel.clear();        // add the preloaded image to main panel        mainPanel.add(preloadImage);        preloadPanel.hide();        // add event for tell others about the end of image loading        for (int i = 0; i < preloadImageEventHandlers.size(); i++) {          preloadImageEventHandlers.get(i).onLoadCompleted();        }      }    });    // add the image to preloadPanel for starting the loading process    preloadPanel.clear();    preloadPanel.add(image);    preloadPanel.show();    // preloadImageEventHandlers.clear();  }  /**   * get the image object   * @return Image object   */  public Image getImage() {    return this.image;  }  /**   * @return widget width (not image width)   */  public int getWidth() {    return this.width;  }  /**   * @return widget height (not image height)   */  public int getHeight() {    return this.height;  }  public void addMouseOverHandler(MouseOverHandler mouseOverHandler) {    if (this.mouseOverHandlers != null && image != null) {      this.mouseOverHandlers.add(mouseOverHandler);      for (int i = 0; i < this.mouseOverHandlers.size(); i++) {        image.addMouseOverHandler(this.mouseOverHandlers.get(i));      }    }  }  public void addPreloadImageEventHandlers(PreloadImageEventHandler preloadImageEventHandler) {    if (this.preloadImageEventHandlers != null) {      this.preloadImageEventHandlers.add(preloadImageEventHandler);    }  }  public void addClickHandler(ClickHandler mouseOverHandler) {    if (this.cliskHandlers != null && image != null) {      this.cliskHandlers.add(mouseOverHandler);      for (int i = 0; i < this.cliskHandlers.size(); i++) {        image.addClickHandler(this.cliskHandlers.get(i));      }    }  }  public void clear() {    preloadImageEventHandlers = new ArrayList<PreloadImageEventHandler>();  }  public int getOriginalWidth() {    return originalWidth;  }  public void setOriginalWidth(int originalWidth) {    this.originalWidth = originalWidth;  }  public int getOriginalheight() {    return originalheight;  }  public void setOriginalheight(int originalheight) {    this.originalheight = originalheight;  }}