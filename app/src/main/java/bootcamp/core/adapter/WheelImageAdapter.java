package bootcamp.core.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import java.util.ArrayList;
import bootcamp.core.R;
import bootcamp.core.entity.Bootcamp;
import bootcamp.core.publico.AppController;
import github.hellocsl.cursorwheel.CursorWheelLayout;

public class WheelImageAdapter extends CursorWheelLayout.CycleWheelAdapter {
    private Context mContext;
    private ArrayList<Bootcamp> menuItems;
    private LayoutInflater inflater;
    private ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public WheelImageAdapter(Context mContext, ArrayList<Bootcamp> menuItems) {
        this.mContext = mContext;
        this.menuItems = menuItems;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return menuItems.size();
    }

    @Override
    public View getView(View parent, int position) {
        Bootcamp data = getItem(position);
        View root = inflater.inflate(R.layout.wheel_image_layout, null, false);
        NetworkImageView imageView = (NetworkImageView) root.findViewById(R.id.wheel_menu_item_iv);
        imageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        imageView.setImageUrl(data.getIcono(), imageLoader);
        return root;
    }

    @Override
    public Bootcamp getItem(int position) {
        return menuItems.get(position);
    }
}
