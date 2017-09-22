using System;
using Android.Support.V7.Widget;
using Android.Views;
using System.Collections.Generic;
using Motogari.Droid.CustomModels;
using Android.Widget;
using Motogari.Models;
using Motogari.Droid.Utils;


namespace Motogari.Droid.Adapters
{
    public class AddressListAdapter : RecyclerView.Adapter
    {


        List<PlaceModel> placeModels;
		AbstractActivity ActivityInstance;  
        public IClickListener clikcListener;

        private Action<PlaceModel> OnItemSelected;

        public AddressListAdapter(AbstractActivity ActivityInstance, List<PlaceModel> placeModels,Action<PlaceModel> OnItemSelected)
		{
			this.ActivityInstance = ActivityInstance;
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
			AddressListHolder vh = holder as AddressListHolder;

            vh.relativeLayoutMain.Tag = position;
              
            vh.txtPlaceName.Text = placeModels[position].AttributedFullText;
             	  	 
		}

		public override RecyclerView.ViewHolder OnCreateViewHolder(ViewGroup parent, int viewType)
		{
			View itemView = LayoutInflater.From(parent.Context).
                                          Inflate(Resource.Layout.row_layout_address, parent, false);
			AddressListHolder vh = new AddressListHolder(itemView);

            vh.relativeLayoutMain.Click += OnItemClick;


			return vh;
		}


		void OnItemClick(object sender, EventArgs e)
		{ 
            
			RelativeLayout rltLayoutMain = (RelativeLayout)sender;
			int pos = (int)rltLayoutMain.Tag;
            OnItemSelected(placeModels[pos]);
			 
		}

		  
    }



	public class AddressListHolder : RecyclerView.ViewHolder
	{
		public RelativeLayout relativeLayoutMain { get; private set; } 
		public TextView txtPlaceName { get; private set; }

		public AddressListHolder(View itemView) : base(itemView)
		{
			// Locate and cache view references:
			relativeLayoutMain = itemView.FindViewById<RelativeLayout>(Resource.Id.rlt_layout_root_main);
			txtPlaceName = itemView.FindViewById<TextView>(Resource.Id.txt_place_name);
		}
	}



}
