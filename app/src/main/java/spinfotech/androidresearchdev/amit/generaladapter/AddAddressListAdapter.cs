using System;
using Android.Support.V7.Widget;
using Android.Views;
using System.Collections.Generic;
using Motogari.Droid.CustomModels;
using Android.Widget;
using Motogari.Models;
using Motogari.Droid.Utils;
using Motogari.Droid.Fragments; 
 

namespace Motogari.Droid.Adapters
{
    public class AddAddressListAdapter:RecyclerView.Adapter
    {
        
    List<PlaceModel> placeModels;
	AbstractActivity activityInstance; 
    private Action<int> OnItemSelected;


	public AddAddressListAdapter(AbstractActivity activityInstance, List<PlaceModel> placeModels,Action<int> OnItemSelected)
	{
		this.activityInstance = activityInstance;
		this.placeModels = placeModels;
        this.OnItemSelected = OnItemSelected;
	}

	public override int ItemCount
	{
		get
		{
			return placeModels.Count;
		}
	}

	public override void OnBindViewHolder(RecyclerView.ViewHolder holder, int position)
	{
		AddressAddListHolder vh = holder as AddressAddListHolder;
             
		    vh.txtPlaceName.Text = placeModels[position].AttributedFullText;

            vh.imgPlaceCancel.Tag = position;

	}

         

        public override RecyclerView.ViewHolder OnCreateViewHolder(ViewGroup parent, int viewType)
        {
            View itemView = LayoutInflater.From(parent.Context).
                                          Inflate(Resource.Layout.row_address_list_with_add, parent, false);
            AddressAddListHolder vh = new AddressAddListHolder(itemView);

            vh.imgPlaceCancel.Click += OnCancelPlaceClick;
             

            return vh;
        }


        public void OnCancelPlaceClick(object sender,EventArgs e){
            ImageView imgCancel = (ImageView)sender;
            int pos = (int)imgCancel.Tag;
            OnItemSelected(pos);
		}
         

}



public class AddressAddListHolder : RecyclerView.ViewHolder
{
	    public TextView txtPlaceName { get; private set; }
	//	public TextView txtPlaceAdd { get; private set; }
        public ImageView imgPlaceCancel { get; private set; } 

	public AddressAddListHolder(View itemView) : base(itemView)
	{
	
		    txtPlaceName = itemView.FindViewById<TextView>(Resource.Id.txt_place_name);
    //        txtPlaceAdd = itemView.FindViewById<TextView>(Resource.Id.txt_place_add);
            imgPlaceCancel = itemView.FindViewById<ImageView>(Resource.Id.img_cancel_place);

	}
}
}
