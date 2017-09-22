using System;
using Android.Support.V7.Widget;
using Android.Views;
using System.Collections.Generic;
using Motogari.Droid.CustomModels;
using Android.Widget;

namespace Motogari.Droid.Adapters
{
    public class CustomMenuAdapter : RecyclerView.Adapter
    {
        
        List<MenuItem> MenuItems;
        AbstractActivity ActivityInstance;
        private int SelectedMenuPosition;

        public CustomMenuAdapter(AbstractActivity ActivityInstance, List<MenuItem> MenuItems)
        {
            this.ActivityInstance = ActivityInstance;
            this.MenuItems = MenuItems;
        }

        public override int ItemCount
        {
            get
            {
                return MenuItems.Count;
            }
        }

        public override void OnBindViewHolder(RecyclerView.ViewHolder holder, int position)
        {
            MenuViewHolder vh = holder as MenuViewHolder;
            vh.RltLayoutMenuRoot.Tag = position;
            vh.ImgMenuIcon.SetImageResource(MenuItems[position].MenuIcon);
            vh.TxtMenuName.Text = MenuItems[position].MenuName;
            if (SelectedMenuPosition == position)
            {
                vh.RltLayoutMenuRoot.Selected = true;
                vh.TxtMenuName.Selected = true;
            }
            else
            {
                vh.RltLayoutMenuRoot.Selected = false;
                vh.TxtMenuName.Selected = false;
            }
        }

        public override RecyclerView.ViewHolder OnCreateViewHolder(ViewGroup parent, int viewType)
        {
            View itemView = LayoutInflater.From(parent.Context).
                                          Inflate(Resource.Layout.Item_menu, parent, false);
            MenuViewHolder vh = new MenuViewHolder(itemView);
            vh.RltLayoutMenuRoot.Click += OnMenuItemClick;
            return vh;
        }


        void OnMenuItemClick(object sender, EventArgs e)
        {

            RelativeLayout rltLayoutMain = (RelativeLayout)sender;
            int pos = (int)rltLayoutMain.Tag;
            if (pos != 0 && pos != 4)
            {
                ((HomeActivity)ActivityInstance).CloseNavigationDrawer();
                return;
            }
            SelectedMenuPosition = pos;
            NotifyDataSetChanged();
            ((HomeActivity)ActivityInstance).OnMenuItemSelected(pos);
        }

    }


    public class MenuViewHolder : RecyclerView.ViewHolder
    {
        public RelativeLayout RltLayoutMenuRoot { get; private set; }
        public ImageView ImgMenuIcon { get; private set; }
        public TextView TxtMenuName { get; private set; }

        public MenuViewHolder(View itemView) : base(itemView)
        {
            // Locate and cache view references:
            RltLayoutMenuRoot = itemView.FindViewById<RelativeLayout>(Resource.Id.rlt_layout_root_main);
            ImgMenuIcon = itemView.FindViewById<ImageView>(Resource.Id.img_menu_icon);
            TxtMenuName = itemView.FindViewById<TextView>(Resource.Id.txt_menu_item);
        }
    }
}
