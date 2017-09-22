using System;

using System.Collections.Generic;
using Android.Graphics;
using Android.Support.V7.Widget;
using Android.Views;
using Android.Widget;
using Java.Text;
using Motogari.Models;
using Motogari.Networking;

namespace Motogari.Droid.Adapters
{
	public class MyBookingCompletedAdapter : RecyclerView.Adapter
	{

		List<MyBookingListModel> BookingListModel;
        int Type;
 
		public MyBookingCompletedAdapter(AbstractActivity ActivityInstance, List<MyBookingListModel> BookingListModel,int Type)
		{
			this.BookingListModel = BookingListModel;
            this.Type = Type;

		}
         
		public override int ItemCount
		{
			get
			{
				return BookingListModel.Count;
			}
		}

		public override void OnBindViewHolder(RecyclerView.ViewHolder holder, int position)
		{
			MyBookingCompletedHolder vh = holder as MyBookingCompletedHolder;

			MyBookingListModel Model = BookingListModel[position];


			SimpleDateFormat DateFormat = new SimpleDateFormat(AppConstants.DATE_FORMATTER);

			String time = new SimpleDateFormat(AppConstants.TIME_FORMATTER).Format(Model.PickupDatetime);


			String date = DateFormat.Format(Model.PickupDatetime);

			vh.TxtTripId.Text = Model.BookingCode;
			vh.TxtDate.Text = date;
			vh.TxtTime.Text = time;

            vh.TxtCarName.Text = Model.DriverFirstName;

            vh.TxtVanName.Text = Model.VehicleType;
            vh.TxtVanType.Text = Model.VehicleNumber;
 
			vh.TxtPickLocation.Text = Model.PickupLocationName;
			vh.TxtDropLocation.Text = Model.DropLocationName;

            var UrlToDownload = APIConstants.FILE_DOWNLOAD + Model.DriverProfileImage;

            if(Model.DriverProfileImage!=null && !Model.DriverProfileImage.Equals("")){
				
            }


            if(Type==1){
                vh.TxtAction.Text = "Cancel";
                vh.TxtAction.SetBackgroundResource(Resource.Drawable.shape_rectangle_bottom_redious);
                vh.TxtCash.Text = "Fare Estimation: $30";
              
            }else{
                vh.TxtCash.Text = "Cash: $30";
            }

 
		}


		 

		public override RecyclerView.ViewHolder OnCreateViewHolder(ViewGroup parent, int viewType)
		{
            View itemView = LayoutInflater.From(parent.Context).Inflate(Resource.Layout.row_layout_completed, parent, false);

			MyBookingCompletedHolder vh = new MyBookingCompletedHolder(itemView);

			return vh;
		}


	}

	public class MyBookingCompletedHolder : RecyclerView.ViewHolder
	{
		public TextView TxtHeaderName { get; private set; }
		public TextView TxtTripId { get; private set; }
		public TextView TxtCarName { get; private set; }
		public TextView TxtDate { get; private set; }
		public TextView TxtTime { get; private set; }
		public TextView TxtPickLocation { get; private set; }
		public TextView TxtDropLocation { get; private set; }
		public TextView TxtViewNote { get; private set; }

		public TextView TxtCash { get; private set; }
		public TextView TxtVanName { get; private set; }
		public TextView TxtVanType { get; private set; }

        public TextView TxtAction { get; private set; }


		public ImageView ImgCarImage { get; private set; }

		public MyBookingCompletedHolder(View itemView) : base(itemView)
		{
			TxtHeaderName = (TextView)itemView.FindViewById(Resource.Id.txt_header_name);
			TxtTripId = (TextView)itemView.FindViewById(Resource.Id.txt_trip_id);
			TxtCarName = (TextView)itemView.FindViewById(Resource.Id.txt_car_name);
			TxtDate = (TextView)itemView.FindViewById(Resource.Id.txt_trip_date);
			TxtTime = (TextView)itemView.FindViewById(Resource.Id.txt_trip_time);
			TxtPickLocation = (TextView)itemView.FindViewById(Resource.Id.txt_pickup_address);
			TxtDropLocation = (TextView)itemView.FindViewById(Resource.Id.txt_delivery_address);
			TxtViewNote = (TextView)itemView.FindViewById(Resource.Id.txt_view_note);

			TxtCash = (TextView)itemView.FindViewById(Resource.Id.txt_cash);
			TxtVanName = (TextView)itemView.FindViewById(Resource.Id.txt_view_car_name);
			TxtVanType = (TextView)itemView.FindViewById(Resource.Id.txt_view_car_type);

            TxtAction = (TextView)itemView.FindViewById(Resource.Id.txt_action_click);

			ImgCarImage = (ImageView)itemView.FindViewById(Resource.Id.profile_image);

		}
	}
}
