using System;
using Android.Support.V7.Widget;
using Android.Views;
using System.Collections.Generic;
using Motogari.Droid.CustomModels;
using Android.Widget;
using Android.Content;
using static Xamarin.Forms.DependencyService;

namespace Motogari.Droid.Adapters
{
    public class CustomListDialogAdapter : RecyclerView.Adapter
    {


        List<SpinnerModel> listItems;
        AbstractActivity ActivityInstance;
        private int SelectedMenuPosition;
        private Context Context;
        private Action<SpinnerModel> OnItemSelected;

        public CustomListDialogAdapter(AbstractActivity ActivityInstance, List<SpinnerModel> listItems)
        {
            this.ActivityInstance = ActivityInstance;
            this.listItems = listItems;
        }

        public CustomListDialogAdapter(Context context, List<SpinnerModel> listItems, Action<SpinnerModel> OnItemSelected)
        {
            this.Context = context;
            this.listItems = listItems;
            this.OnItemSelected = OnItemSelected;
        }

        public override int ItemCount
        {
            get
            {
                return listItems.Count;
            }
        }

        public override void OnBindViewHolder(RecyclerView.ViewHolder holder, int position)
        {
            ItemViewHolder vh = holder as ItemViewHolder;
            vh.RltLayoutMenuRoot.Tag = position;
            vh.RbSelection.Tag = position;
            vh.TxtMenuName.Text = listItems[position].item;
            if (SelectedMenuPosition == position)
            {
                vh.RltLayoutMenuRoot.Selected = true;
                vh.TxtMenuName.Selected = true;
                vh.RbSelection.Checked = true;
            }
            else
            {
                vh.RltLayoutMenuRoot.Selected = false;
                vh.TxtMenuName.Selected = false;
                vh.RbSelection.Checked = false;
            }
        }

        public override RecyclerView.ViewHolder OnCreateViewHolder(ViewGroup parent, int viewType)
        {
            View itemView = LayoutInflater.From(parent.Context).
                                          Inflate(Resource.Layout.item_dialog_list, parent, false);
            ItemViewHolder vh = new ItemViewHolder(itemView);
            vh.RltLayoutMenuRoot.Click += OnItemClick;
            vh.RbSelection.Click += OnItemClick;
            OnItemSelected(listItems[0]);
            return vh;
        }


        void OnItemClick(object sender, EventArgs e)
        {
            int pos = 0;
            if (sender is RelativeLayout)
            {
                RelativeLayout rltLayoutMain = (RelativeLayout)sender;
                pos = (int)rltLayoutMain.Tag;
            }
            else if (sender is RadioButton)
            {
                RadioButton rbButton = (RadioButton)sender;
                pos = (int)rbButton.Tag;
            }

            SelectedMenuPosition = pos;
            NotifyDataSetChanged();
            OnItemSelected(listItems[pos]);
        }

    }


    public class ItemViewHolder : RecyclerView.ViewHolder
    {
        public RelativeLayout RltLayoutMenuRoot { get; private set; }
        public RadioButton RbSelection { get; private set; }
        public TextView TxtMenuName { get; private set; }

        public ItemViewHolder(View itemView) : base(itemView)
        {
            // Locate and cache view references:
            RltLayoutMenuRoot = itemView.FindViewById<RelativeLayout>(Resource.Id.rlt_layout_root_main);
            RbSelection = itemView.FindViewById<RadioButton>(Resource.Id.rb_select);
            TxtMenuName = itemView.FindViewById<TextView>(Resource.Id.txt_item);
        }
    }
}
