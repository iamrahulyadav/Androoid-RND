using System;
using Android.Support.V7.Widget;
using Motogari.Models;
using System.Collections.Generic;
using Android.Views;
using Android.Widget;
using Motogari.Droid;
using Android.Content;

namespace Motogari.Droid.Adapters
{
	public class VehicleTypeAdapter : RecyclerView.Adapter
	{
         
        List<VehicleTypesModel> VehicleTypeList;
		AbstractActivity ActivityInstance;
		int selectedItem = 0;

		private Action<int> OnItemSelected;

 
		public VehicleTypeAdapter(AbstractActivity ActivityInstance, List<VehicleTypesModel> VehicleTypeList, Action<int> OnItemSelected)
		{
			this.ActivityInstance = ActivityInstance;
			this.VehicleTypeList = VehicleTypeList;
			this.OnItemSelected = OnItemSelected;
		}

		public override int ItemCount
		{
			get
			{
				return VehicleTypeList.Count;
			}
		}

		public override void OnBindViewHolder(RecyclerView.ViewHolder holder, int position)
		{
			VehicleTypeHolder vh = holder as VehicleTypeHolder;

		 	vh.relativeLayoutMain.Tag = position;

            vh.txtVehicleeName.Text = VehicleTypeList[position].VehicleType;
         
           

			if (selectedItem == position)
			{
				vh.relativeLayoutMain.Selected = true;
                vh.txtVehicleeName.SetTextColor(ActivityInstance.Resources.GetColor(Resource.Color.color_black));

                switch(selectedItem){
                    case 0:
                        vh.imgVehicleTypeIcon.SetImageResource(Resource.Drawable.Taxi1Selected);
                        break;
                    case 1:
						vh.imgVehicleTypeIcon.SetImageResource(Resource.Drawable.Taxi2Selected);
                        break;
                    case 2:
						vh.imgVehicleTypeIcon.SetImageResource(Resource.Drawable.Taxi3Selected);
                        break;
                }
			}
			else
			{
				vh.relativeLayoutMain.Selected = false;
				vh.txtVehicleeName.SetTextColor(ActivityInstance.Resources.GetColor(Resource.Color.color_8a8a8a));
                switch (position)
				{
					case 0:
						vh.imgVehicleTypeIcon.SetImageResource(Resource.Drawable.Taxi1);
						break;
					case 1:
						vh.imgVehicleTypeIcon.SetImageResource(Resource.Drawable.Taxi2);
						break;
					case 2:
						vh.imgVehicleTypeIcon.SetImageResource(Resource.Drawable.Taxi3);
						break;
				}
			}
		}


        public VehicleTypesModel GetSelectedMode(){
            return VehicleTypeList[selectedItem];
        }

 
		public override RecyclerView.ViewHolder OnCreateViewHolder(ViewGroup parent, int viewType)
		{
			View itemView = LayoutInflater.From(parent.Context).
										  Inflate(Resource.Layout.row_layout_vehicle_type, parent, false);
			VehicleTypeHolder vh = new VehicleTypeHolder(itemView);

			vh.relativeLayoutMain.Click += OnItemClick;
             
			return vh;
		}


		void OnItemClick(object sender, EventArgs e)
		{ 
			RelativeLayout rltLayoutMain = (RelativeLayout)sender;
			int pos = (int)rltLayoutMain.Tag;
			selectedItem = pos;
			NotifyDataSetChanged();
			OnItemSelected(pos); 
		}
         
	}



	public class VehicleTypeHolder : RecyclerView.ViewHolder
	{
		public RelativeLayout relativeLayoutMain { get; private set; }
        
		public TextView txtVehicleeName { get; private set; }
		public ImageView imgVehicleTypeIcon { get; private set; }

		public VehicleTypeHolder(View itemView) : base(itemView)
		{
			// Locate and cache view references:
			relativeLayoutMain = itemView.FindViewById<RelativeLayout>(Resource.Id.rel_layout_vehicle_parent);
             
             
			txtVehicleeName = itemView.FindViewById<TextView>(Resource.Id.txt_vehicle_name);
			imgVehicleTypeIcon = itemView.FindViewById<ImageView>(Resource.Id.img_vehicle_icon);
		}

		 


	}



}