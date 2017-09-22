using System;
using System.Collections.Generic;
using System.Linq;
using Android.App;
using Android.Views;
using Android.Widget;
using Motogari.Droid.CustomModels;
using Android.Content;
namespace Motogari.Droid.Adapters
{
    public class CustomDropdownAdapterNew : BaseAdapter<SpinnerModel>
    {

        List<SpinnerModel> Items;
        Activity ActivityContext;
        private bool ToShowPrompt;
       

        public CustomDropdownAdapterNew(Activity context, List<SpinnerModel> items, bool ToShowPrompt)
           : base()
        {
            this.ActivityContext = context;
            this.Items = items;
            this.ToShowPrompt = ToShowPrompt;
        }

       



        public override long GetItemId(int position)
        {
            return position;
        }
        public override SpinnerModel this[int position]
        {
            get { return Items[position]; }
        }

        //public override SpinnerModel GetItem(int position)
        //{
        //    return Items(position);
        //}

        public override int Count
        {
            //get
            //{

            //    if (ToShowPrompt)
            //    {
            //        return Items.Count - 1;
            //    }
            //    else
            //    {
            //        return Items.Count;
            //    }

            //}

            get
            {

                return Items.Count;

            }
        }


        public override View GetView(int position, View convertView, ViewGroup parent)
        {

            View view = convertView; // re-use an existing view, if one is available
            if (view == null) // otherwise create a new one
            {
                view = ActivityContext.LayoutInflater.Inflate(Resource.Layout.item_spinner, null);
            }
            view.FindViewById<TextView>(Resource.Id.txt_spinner_list_item).Text = Items[position].item;

            return view;

        }


        public override View GetDropDownView(int position, View convertView, ViewGroup parent)
        {

            View view = convertView; // re-use an existing view, if one is available
            if (view == null) // otherwise create a new one
            {
                view = ActivityContext.LayoutInflater.Inflate(Resource.Layout.item_spinner_dropdown, null);
            }
            view.FindViewById<TextView>(Resource.Id.txt_spinner_list_item).Text = Items[position].item;
            if (ToShowPrompt && position == Items.Count - 1)
            {
                view.FindViewById<TextView>(Resource.Id.txt_spinner_list_item).Visibility = ViewStates.Gone;
            }
            else
            {
                view.FindViewById<TextView>(Resource.Id.txt_spinner_list_item).Visibility = ViewStates.Visible;
            }

            return view;
        }

    }

}





