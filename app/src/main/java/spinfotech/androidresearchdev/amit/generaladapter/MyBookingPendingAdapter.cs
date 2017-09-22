using System;
using System.Collections.Generic;
using Android.Support.V7.Widget;
using Android.Views;
using Android.Widget;
using Java.Text;
using Motogari.Models;


namespace Motogari.Droid.Adapters
{
    public class MyBookingPendingAdapter : RecyclerView.Adapter
    {

        List<MyBookingListModel> BookingListModel;
		

        public MyBookingPendingAdapter(AbstractActivity ActivityInstance,List<MyBookingListModel> BookingListModel)
		{
            this.BookingListModel = BookingListModel;
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
			MyBookingPendginHolder vh = holder as MyBookingPendginHolder;

			MyBookingListModel Model = BookingListModel[position];

           
            SimpleDateFormat DateFormat = new SimpleDateFormat(AppConstants.DATE_FORMATTER);
              
            String time = new SimpleDateFormat(AppConstants.TIME_FORMATTER).Format(Model.PickupDatetime);


            String date = DateFormat.Format(Model.PickupDatetime);
        
            vh.TxtTripId.Text = Model.BookingCode;
            vh.TxtCarName.Text = Model.VehicleType;
            vh.TxtDate.Text = date;
		     vh.TxtTime.Text = time;

			vh.TxtPickLocation.Text = Model.PickupLocationName;
            vh.TxtDropLocation.Text = Model.DropLocationName;

			 
             

		//	vh.imgPlaceCancel.Tag = position;

		}



		public override RecyclerView.ViewHolder OnCreateViewHolder(ViewGroup parent, int viewType)
		{
            View itemView = LayoutInflater.From(parent.Context).Inflate(Resource.Layout.row_layout_my_bookings, parent, false);

			MyBookingPendginHolder vh = new MyBookingPendginHolder(itemView);
             
			return vh;
		}
  

	}

	public class MyBookingPendginHolder : RecyclerView.ViewHolder
	{
        public TextView TxtHeaderName { get; private set; }
		public TextView TxtTripId { get; private set; }
        public TextView TxtCarName { get; private set; }
        public TextView TxtDate { get; private set; }

        public TextView TxtTime { get; private set; }
        public TextView TxtPickLocation { get; private set; }
        public TextView TxtDropLocation { get; private set; }
        public TextView TxtViewNote { get; private set; }

 
		public ImageView ImgCarImage { get; private set; }

		public MyBookingPendginHolder(View itemView) : base(itemView)
		{
			TxtHeaderName = (TextView)itemView.FindViewById(Resource.Id.txt_header_name);
			TxtTripId = (TextView)itemView.FindViewById(Resource.Id.txt_trip_id);
			TxtCarName = (TextView)itemView.FindViewById(Resource.Id.txt_car_name);
			TxtDate = (TextView)itemView.FindViewById(Resource.Id.txt_trip_date);
			TxtTime = (TextView)itemView.FindViewById(Resource.Id.txt_trip_time);
			TxtPickLocation = (TextView)itemView.FindViewById(Resource.Id.txt_pickup_address);
			TxtDropLocation = (TextView)itemView.FindViewById(Resource.Id.txt_delivery_address);
			TxtViewNote = (TextView)itemView.FindViewById(Resource.Id.txt_view_note);
			ImgCarImage = (ImageView)itemView.FindViewById(Resource.Id.profile_image);
 
		}
	}
 

}
