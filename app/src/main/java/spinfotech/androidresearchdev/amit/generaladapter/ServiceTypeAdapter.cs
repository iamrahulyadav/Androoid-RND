using System;
using Android.Support.V7.Widget;
using Motogari.Models;
using System.Collections.Generic;
using Android.Views;
using Android.Widget;
using Motogari.Droid;

namespace Motogari.Droid.Adapters
{
	public class ServiceTypeAdapter : RecyclerView.Adapter
	{
        
        List<ServiceTypesModel> serviceTypeModel;
		AbstractActivity ActivityInstance;
        int selectedItem = -1;

		private Action<ServiceTypesModel> OnItemSelected;
 
		public ServiceTypeAdapter(AbstractActivity ActivityInstance, List<ServiceTypesModel> serviceTypeModel, Action<ServiceTypesModel> OnItemSelected)
		{
			this.ActivityInstance = ActivityInstance;
			this.serviceTypeModel = serviceTypeModel;
			this.OnItemSelected = OnItemSelected;
		}

		public override int ItemCount
		{
			get
			{
				return serviceTypeModel.Count;
			}
		}

		public override void OnBindViewHolder(RecyclerView.ViewHolder holder, int position)
		{
			ServiceTypeHolder vh = holder as ServiceTypeHolder;

			vh.relativeLayoutMain.Tag = position;

            vh.txtServiceName.Text = serviceTypeModel[position].ServiceType;

            vh.imgServiceTypeIcon.SetImageResource(serviceTypeModel[position].ServiceImageType);

            if(selectedItem==position){
                vh.relativeLayoutMain.Selected = true;
                vh.txtServiceName.SetTextColor(ActivityInstance.Resources.GetColor(Resource.Color.color_fe5158));
            }else{
                vh.relativeLayoutMain.Selected = false;
                vh.txtServiceName.SetTextColor(ActivityInstance.Resources.GetColor(Resource.Color.text_color));
            }
             
		}

		public override RecyclerView.ViewHolder OnCreateViewHolder(ViewGroup parent, int viewType)
		{
			View itemView = LayoutInflater.From(parent.Context).
                                          Inflate(Resource.Layout.row_service_type_item, parent, false);
			ServiceTypeHolder vh = new ServiceTypeHolder(itemView);

			vh.relativeLayoutMain.Click += OnItemClick;


			return vh;
		}

        public void ItemSelected(int position){
            selectedItem = position;
        }


		void OnItemClick(object sender, EventArgs e)
		{

			RelativeLayout rltLayoutMain = (RelativeLayout)sender;
			int pos = (int)rltLayoutMain.Tag;
            selectedItem = pos;
            NotifyDataSetChanged();
		    OnItemSelected(serviceTypeModel[pos]);

		}


	}



    public class ServiceTypeHolder : RecyclerView.ViewHolder
    {
        public RelativeLayout relativeLayoutMain { get; private set; }
        public TextView txtServiceName { get; private set; }
        public ImageView imgServiceTypeIcon { get; private set; } 

		public ServiceTypeHolder(View itemView) : base(itemView)
		{
			// Locate and cache view references:
			relativeLayoutMain = itemView.FindViewById<RelativeLayout>(Resource.Id.rel_layout_service_parent);
			txtServiceName = itemView.FindViewById<TextView>(Resource.Id.txt_service_name);
            imgServiceTypeIcon = itemView.FindViewById<ImageView>(Resource.Id.img_service_icon);
		}
	}



}